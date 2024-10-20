import streamlit as st
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import pickle
import json
import numpy as np

#with open('C:/Users/Admin/random_forest_model.pkl', 'rb') as f:
   # model = pickle.load(f)

with open('C:/Users/Admin/random_forest_model.pkl', 'rb') as f:
    model = pickle.load(f)

with open("C:/Users/Admin/columns.json", "r") as f:
    data_columns = json.load(f)['data_columns']

def create_byage_df(df):
    df['Age Group'] = df['Age'].apply(lambda x: 'Young' if x <= 30 else ('Senior' if x > 51 else 'Middle-aged'))
    byage = df.groupby('Age Group').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return byage

def create_byloc_df(df):
    byloc = df.groupby('Location').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return byloc

def create_bygender_df(df):
    bygender = df.groupby('Gender').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return bygender

def create_bysubs_df(df):
    bysubs = df.groupby('Subscription Status').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return bysubs

def create_bypromo_df(df):
    bypromo = df.groupby(['Discount Applied', 'Promo Code Used']).agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return bypromo 

def create_bypayment_df(df):
    bypayment = df.groupby('Payment Method').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return bypayment

def create_bycategory_df(df):
    bycategory = df.groupby('Category').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return bycategory

def create_byitems_df(df):
    byitems = df.groupby(['Category', 'Item Purchased']).agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return byitems

def create_bysize_df(df):
    bysize = df.groupby('Size').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return bysize

def create_bycolor_df(df):
    bycolor = df.groupby('Color').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return bycolor

def create_byrating_df(df):
    df['Rating Group'] = df['Review Rating'].apply(lambda x: 'Fair' if x < 3.5 else('Excellent' if x >= 4 else 'Decent'))
    byrating = df.groupby('Rating Group').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return byrating 

def create_product_preferences_df(df):
    product_pref = df.groupby('Category').agg({'Customer ID': 'nunique'}).rename(columns={'Customer ID': 'Customer Count'}).reset_index()
    return product_pref

# Load data
df = pd.read_csv('shopping_behavior_updated.csv')

# Create Age Group column

df['Age Group'] = df['Age'].apply(lambda x: 'Young' if x <= 30 else ('Senior' if x > 51 else 'Middle-aged'))

st.sidebar.header("Navigation")
page = st.sidebar.selectbox("Select Page:", ["Customer Behavior Analysis", "Churn Prediction"])

if page == "Customer Behavior Analysis":
    # Sidebar Filters
    st.sidebar.header("Customer Behavior Analysis")
    st.sidebar.markdown("### Filter the data to customize your analysis")

    # Age Filter
    age_options = st.sidebar.multiselect('Select Age Group:', options=['Young', 'Middle-aged', 'Senior'], default=['Young', 'Middle-aged', 'Senior'])

    # Subscription Status Filter
    subscription_options = st.sidebar.multiselect('Select Subscription Status:', options=['Yes', 'No'], default=['Yes', 'No'])

    # Location Filter
    location_options = st.sidebar.multiselect('Select Location:', options=df['Location'].unique(), default=df['Location'].unique().tolist())

    # Product Category Filter
    category_options = st.sidebar.multiselect('Select Product Category:', options=df['Category'].unique(), default=df['Category'].unique().tolist())

    # Item Filter
    item_options = st.sidebar.multiselect('Select Items:', options=df['Item Purchased'].unique(), default=df['Item Purchased'].unique().tolist())

    # Size Filter
    size_options = st.sidebar.multiselect('Select Size:', options=df['Size'].unique(), default=df['Size'].unique().tolist())

    # Color Filter
    color_options = st.sidebar.multiselect('Select Color:', options=df['Color'].unique(), default=df['Color'].unique().tolist())

    # Rating Filter
    rating_options = st.sidebar.multiselect('Select Rating:', options=['Fair', 'Decent', 'Excellent'], default=['Fair', 'Decent', 'Excellent'])

    # Applying Filters to the DataFrame
    filtered_df = df[
        (df['Age Group'].isin(age_options)) &
        (df['Subscription Status'].isin(subscription_options)) &
        (df['Location'].isin(location_options)) &
        (df['Category'].isin(category_options)) &
        (df['Item Purchased'].isin(item_options)) &
        (df['Size'].isin(size_options)) &
        (df['Color'].isin(color_options)) &
        (df['Review Rating'].apply(lambda x: 'Fair' if x < 3.5 else ('Excellent' if x >= 4 else 'Decent')).isin(rating_options))
    ]

    # Calculate metrics based on filtered_df
    byage_df = create_byage_df(filtered_df)
    byloc_df = create_byloc_df(filtered_df)
    bygender_df = create_bygender_df(filtered_df)
    bysubs_df = create_bysubs_df(filtered_df)
    bypromo_df = create_bypromo_df(filtered_df)
    bypayment_df = create_bypayment_df(filtered_df)
    bycategory_df = create_bycategory_df(filtered_df)
    byitems_df = create_byitems_df(filtered_df)
    bysize_df = create_bysize_df(filtered_df)
    bycolor_df = create_bycolor_df(filtered_df)
    byrating_df = create_byrating_df(filtered_df)
    product_pref_df = create_product_preferences_df(filtered_df)

    st.title("Customer Behavior Dashboard :sparkles:")
    st.divider()

    # Display metrics
    col1, col2, col3 = st.columns(3)
    with col1:
        subscribed_cust = filtered_df[filtered_df['Subscription Status'] == 'Yes'].shape[0]
        st.metric('Subscribed Customers', value='{:,}'.format(subscribed_cust))

    with col2:
        notsubscribed_cust = filtered_df[filtered_df['Subscription Status'] == 'No'].shape[0]
        st.metric('Non-Subscribed Customers', value='{:,}'.format(notsubscribed_cust))

    with col3:
        total_cust = filtered_df['Customer ID'].nunique()
        st.metric('Total Customers', value='{:,}'.format(total_cust))

    st.divider()

    st.header(':blue[Customer Profile]')
    tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8 = st.tabs(['AGE', 'LOCATION', 'PAYMENT', 'GENDER', 'SUBSCRIPTION STATUS', 'PROMO USED', 'PRODUCT PREFERENCES', 'ITEMS'])

    with tab1:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5', '#C4E9F5']

            sns.barplot(
                data=byage_df.sort_values(by='Customer Count', ascending=False),
                x='Age Group',
                y='Customer Count',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    with tab2:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5', '#C4E9F5', '#C4E9F5', '#C4E9F5']

            sns.barplot(
                data=byloc_df.sort_values(by='Customer Count', ascending=False).head(),
                x='Location',
                y='Customer Count',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    with tab3:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5', '#C4E9F5', '#C4E9F5', '#C4E9F5']

            sns.barplot(
                data=bypayment_df.sort_values(by='Customer Count', ascending=False),
                x='Payment Method',
                y='Customer Count',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    with tab4:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5']

            sns.barplot(
                data=bygender_df.sort_values(by='Customer Count', ascending=False),
                x='Gender',
                y='Customer Count',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    with tab5:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5']

            sns.barplot(
                data=bysubs_df.sort_values(by='Customer Count', ascending=False),
                x='Subscription Status',
                y='Customer Count',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    with tab6:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5']

            sns.barplot(
                data=bypromo_df.sort_values(by='Customer Count', ascending=False),
                x='Promo Code Used',
                y='Customer Count',
                hue='Discount Applied',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    with tab7:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5']

            sns.barplot(
                data=product_pref_df.sort_values(by='Customer Count', ascending=False),
                x='Category',
                y='Customer Count',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    with tab8:
        col1, col2 = st.columns(2)

        with col1:
            fig, ax = plt.subplots(figsize=(5, 5))
            colors = ['#72BCD4', '#C4E9F5']

            sns.barplot(
                data=byitems_df.sort_values(by='Customer Count', ascending=False),
                x='Item Purchased',
                y='Customer Count',
                palette=colors
            )
            
            plt.xlabel(None)
            plt.ylabel(None)
            st.pyplot(fig)

    # Star Rating Display Function
    def display_star_rating(rating):
        star_html = ""
        for i in range(1, 6):
            if i <= rating:
                star_html += "⭐"  # Filled star
            else:
                star_html += "☆"  # Empty star
        return star_html

    st.header(":blue[Customer Ratings]")
    for index, row in byrating_df.iterrows():
        st.write(f"{row['Rating Group']}: {display_star_rating(row['Customer Count'])}")

    # Optional: Add a button to download filtered data
    st.sidebar.download_button("Download Filtered Data", data=filtered_df.to_csv(), file_name="filtered_data.csv", mime="text/csv")

elif page == "Churn Prediction":
    # Streamlit app title for Churn Prediction
    st.title("Churn Prediction App")

    # Create input fields for user data
    age = st.number_input("Age", min_value=0, max_value=120, value=30)
    gender = st.selectbox("Gender", options=["Male", "Female"])
    item_purchased = st.text_input("Item Purchased")
    category = st.text_input("Category")
    purchase_amount = st.number_input("Purchase Amount (USD)", min_value=0.0)
    location = st.text_input("Location")
    size = st.text_input("Size")
    color = st.text_input("Color")
    season = st.text_input("Season")
    review_rating = st.number_input("Review Rating", min_value=0.0, max_value=5.0)
    subscription_status = st.selectbox("Subscription Status", options=["Yes", "No"])
    shipping_type = st.text_input("Shipping Type")
    discount_applied = st.selectbox("Discount Applied", options=["Yes", "No"])
    promo_code_used = st.selectbox("Promo Code Used", options=["Yes", "No"])
    previous_purchases = st.number_input("Previous Purchases", min_value=0)
    payment_method = st.text_input("Payment Method")
    frequency_of_purchases = st.text_input("Frequency of Purchases")

    # Predict button
    if st.button("Predict Churn"):
    # Prepare the input data for prediction
        input_data = {
            'Age': age,
            'Gender': gender.lower().replace(' ', '_'),
            'Item Purchased': item_purchased.lower().replace(' ', '_'),
            'Category': category.lower().replace(' ', '_'),
            'Purchase Amount': purchase_amount,
            'Location': location.lower().replace(' ', '_'),
            'Size': size.lower().replace(' ', '_'),
            'Color': color.lower().replace(' ', '_'),
            'Season': season.lower().replace(' ', '_'),
            'Review Rating': review_rating,
            'Subscription Status': 1 if subscription_status == 'Yes' else 0,
            'Shipping Type': shipping_type.lower().replace(' ', '_'),
            'Discount Applied': 1 if discount_applied == 'Yes' else 0,
            'Promo Code Used': 1 if promo_code_used == 'Yes' else 0,
            'Previous Purchases': previous_purchases,
            'Payment Method': payment_method.lower().replace(' ', '_'),
            'Frequency of Purchases': frequency_of_purchases.lower().replace(' ', '_')
        }
        if any(value == "" for key, value in input_data.items() if key not in ['Purchase Amount', 'Previous Purchases']):
            st.error("Please fill in all required fields.")
        else:   
            st.write(f"Model type: {type(model)}")

            if hasattr(model, 'predict_proba'):
        # Prepare the input data for prediction
                input_array = np.zeros(len(data_columns))
                for i, col in enumerate(data_columns):
                    if col in input_data:
                        input_array[i] = input_data[col]
                    elif col in input_data.keys():
                        if f"{col}_{input_data[col]}" in data_columns:
                            input_array[data_columns.index(f"{col}_{input_data[col]}")] = 1

        # Get the prediction probability
                output_probab = model.predict_proba([input_array])[0][1]
                pred = "Churn" if output_probab > 0.4 else "Not Churn"

        # Display the result
                st.success(f"Prediction: {pred} (Probability: {output_probab:.4f})")
            else:
                st.error("Loaded model does not support probability predictions.")

        
        
        
        # One-hot encode the categorical variables
        # input_array = np.zeros(len(data_columns))
        # for i, col in enumerate(data_columns):
        #     if col in input_data:
        #         input_array[i] = input_data[col]
        #     elif col in input_data.keys():
        #         if f"{col}_{input_data[col]}" in data_columns:
        #             input_array[data_columns.index(f"{col}_{input_data[col]}")] = 1

        # # Get the prediction probability
        # output_probab = model.predict_proba([input_array])[0][1]
        # pred = "Churn" if output_probab > 0.4 else "Not Churn"

        # # Display the result
        # st.success(f"Prediction: {pred} (Probability: {output_probab:.4f})")