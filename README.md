🛍️ Fashion E-Commerce Android App

Ứng dụng bán quần áo xây dựng bằng Kotlin – MVVM – REST API, hướng tới kiến trúc chuẩn, dễ mở rộng và phù hợp làm đồ án tốt nghiệp.

I. 🧱 Architecture & Project Structure
1️⃣ Kiến trúc: MVVM + Repository Pattern
data/
│── model/          # Data models
│── remote/         # API service & network layer
│── repository/     # Data handling logic

ui/
│── home/
│── category/
│── cart/
│── profile/
│── productdetail/
│── auth/

viewmodel/          # ViewModels
utils/              # Extensions, helpers
2️⃣ Technology Stack

Kotlin

MVVM Architecture

Retrofit (REST API)

Gson / Moshi

Hilt (Dependency Injection)

Kotlin Coroutines

Glide (Image Loading)

Paging 3

ViewBinding

Room (Local Database)

DataStore (Token storage)

II. 🔐 Authentication

Login

Register

Form Validation

Token storage (DataStore)

Auto Login

Logout

Bonus

Forgot Password

Google Sign-In

III. 🏠 Home Screen

Banner slider (ViewPager2)

New Products

Best Sellers

Grid layout (RecyclerView + GridLayoutManager)

Pull to refresh

IV. 🗂 Category Screen

Category listing (Men / Women / Shirts / Pants / etc.)

Filter by category

Filter by price range

Sort:

Price ascending

Price descending

Newest

V. 🔎 Search

SearchView integration

Debounce search (300–500ms)

Search API integration

Search history storage

VI. 📦 Product Detail

Product images (ViewPager2)

Select size

Select color

Quantity selector

Add to cart

Display reviews & ratings

VII. 🛒 Cart

Display cart items

Update quantity

Remove items

Calculate total price

Local cart storage (Room)

VIII. 💳 Checkout

Shipping address input

Payment methods:

Cash on Delivery (COD)

VNPay (Optional – advanced feature)

Create order

Order success screen

IX. 👤 Profile

View user information

Update profile

Order history

Order detail screen

X. 🌐 Networking Layer

ApiService interface

Repository pattern

UI State handling:

Loading

Success

Error

Global error handling

Token interceptor (Authentication)

XI. 🎨 UI/UX Enhancements

Skeleton loading

Shimmer effect

Error screen

Empty state (e.g., empty cart)

Add-to-cart animation

Cart badge counter

Dark Mode support

XII. 🚀 Advanced Features (For Higher Grade)

Paging 3 implementation

Offline cache

Unit Testing (ViewModel)

Clean Architecture (Domain layer)

CI/CD (GitHub Actions)

XIII. 📊 Documentation (For Thesis Report)

Requirement analysis

Use Case Diagram

Class Diagram

Sequence Diagram

System architecture

MVVM explanation

API structure

UI Screenshots

🎯 Project Goal

Build a scalable, maintainable and production-ready Android fashion shopping application that demonstrates:

Modern Android development practices

Clean architecture principles

REST API integration

Professional UI/UX implementation
