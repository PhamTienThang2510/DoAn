# 📱 NOTCH/CAMERA CUTOUT FIX

**Issue:** Search bar bị che bởi camera notch trên màn hình giọt nước

**Date Fixed:** March 2, 2026

---

## 🔧 What Was Fixed

### **Problem**
Trên các thiết bị Android với camera notch (camera giọt nước), thanh SearchView bị che khuất bởi camera cutout. Người dùng không thể nhìn rõ hoặc tương tác với thanh tìm kiếm.

### **Root Cause**
- Layout không có padding trên đủ lớn
- Không sử dụng `fitsSystemWindows` để tự động điều chỉnh cho notch
- Padding được áp dụng đều trên tất cả các cạnh

### **Solution Applied**

**File Modified:** `app/src/main/res/layout/fragment_home.xml`

**Before:**
```xml
<LinearLayout
    android:padding="12dp">
    <SearchView ... />
</LinearLayout>
```

**After:**
```xml
<LinearLayout
    android:paddingLeft="12dp"
    android:paddingRight="12dp"
    android:paddingBottom="12dp"
    android:paddingTop="24dp"
    android:fitsSystemWindows="true">
    <SearchView
        android:layout_marginTop="8dp" ... />
</LinearLayout>
```

---

## 📊 Changes Made

| Element | Change | Details |
|---------|--------|---------|
| **paddingTop** | 12dp → 24dp | Tăng khoảng cách trên để tránh notch |
| **fitsSystemWindows** | Added | Android tự động điều chỉnh cho notch/statusbar |
| **SearchView marginTop** | 0 → 8dp | Thêm margin phía trên |
| **Other padding** | Unchanged | Left, Right, Bottom giữ nguyên 12dp |

---

## ✅ How It Works

### **fitsSystemWindows="true"**
- Attribute này cho phép Android framework tự động điều chỉnh layout
- Layout sẽ được inset (dịch vào trong) để tránh notch và system UI
- Hoạt động trên Android 5.0+ và tất cả các device có notch

### **Padding Top 24dp**
- Cung cấp khoảng cách an toàn từ phía trên
- Đảm bảo được 8dp buffer thêm ngoài notch adjustment

### **SearchView Margin Top 8dp**
- Thêm khoảng cách trên SearchView
- Cách xa hơn từ notch/statusbar

---

## 🎯 Result

✅ Search bar không bị che bởi camera notch  
✅ Có đủ khoảng cách từ statusbar  
✅ Layout vẫn responsive trên tất cả devices  
✅ Hoạt động tốt trên device không notch  

---

## 📱 Tested On

- Devices với notch (waterdrop camera)
- Devices không notch
- Tất cả API level 30+

---

## 💡 Technical Details

**What is fitsSystemWindows?**
- Nó là một attribute của ViewGroup
- Cho phép layout tự động điều chỉnh cho system UI (statusbar, notch, navigationbar)
- Framework sẽ tính toán insets và áp dụng vào padding/layout

**Why Padding Top 24dp?**
- Notch height thường là 20-32dp tùy theo device
- 24dp là giá trị an toàn giữa tất cả devices
- Plus thêm 8dp buffer từ fitsSystemWindows adjustment

---

## 🔄 Before & After

### **Before Fix**
```
[StatusBar/Notch] ← Search bar bị che ❌
[Search Bar     ]
[Banner 1       ]
[Banner 2       ]
[Banner 3       ]
[Products...]
```

### **After Fix**
```
[StatusBar/Notch]
[Spacing        ] ← Padding và fitsSystemWindows
[Search Bar     ] ← Fully visible ✅
[Banner 1       ]
[Banner 2       ]
[Banner 3       ]
[Products...]
```

---

## 📋 Summary

**Issue:** Search bar bị che bởi notch  
**Root Cause:** Không có padding/fitsSystemWindows đủ  
**Fix Applied:** Thêm padding trên, thêm fitsSystemWindows  
**Status:** ✅ FIXED  

**The search bar is now fully visible and properly positioned away from the notch!**


