# 🧪 TESTING GUIDE - HOME PAGE

## Quick Start Testing

### 1. Search Functionality
**Test Case 1: Basic Search**
- [ ] Type "laptop" in search bar
- [ ] Expected: Shows only Laptop Dell XPS
- [ ] Type "iphone" 
- [ ] Expected: Shows only iPhone 15 Pro
- [ ] Clear search field
- [ ] Expected: All 6 products shown

**Test Case 2: Case-Insensitive Search**
- [ ] Type "WATCH" (uppercase)
- [ ] Expected: Samsung Galaxy Watch shown
- [ ] Type "iPhOne" (mixed case)
- [ ] Expected: iPhone 15 Pro shown

**Test Case 3: Description Search**
- [ ] Type "máy tính" (appears in descriptions)
- [ ] Expected: Laptop, iPad, MacBook shown

**Test Case 4: No Results**
- [ ] Type "xyz123" (non-existent)
- [ ] Expected: Empty list shown

---

### 2. Banner Carousel
**Test Case 1: Banner Display**
- [ ] See 3 banners visible
- [ ] Each banner is 300dp wide, 180dp tall
- [ ] Banners show: title, discount %, description, "Mua ngay" button
- [ ] Background color is red (#FF6B6B)

**Test Case 2: Banner Scrolling**
- [ ] Swipe left on banners
- [ ] Expected: Next banner slides in
- [ ] Swipe right
- [ ] Expected: Previous banner shows

**Test Case 3: Banner Click Events**
- [ ] Click on banner card
- [ ] Expected: Toast message "Clicked: [banner title]"
- [ ] Click "Mua ngay" button
- [ ] Expected: Toast message "Clicked: [banner title]"

---

### 3. Featured Products List
**Test Case 1: Product Display**
- [ ] See product list below "Sản phẩm nổi bật" title
- [ ] Each product card shows:
  - [ ] Product image (100×100dp placeholder)
  - [ ] Product name (bold)
  - [ ] Product description (gray text)
  - [ ] Price in red (#FF6B6B)
  - [ ] 5-star rating
  - [ ] Heart icon for favorite

**Test Case 2: Product Scrolling**
- [ ] Scroll down list
- [ ] Expected: More products appear smoothly
- [ ] Each item is 120dp tall

**Test Case 3: Product Click Events**
- [ ] Click on product card
- [ ] Expected: Toast message "Product: [product name]"
- [ ] Example: "Product: Laptop Dell XPS"

**Test Case 4: Favorite Button**
- [ ] Click heart icon on any product
- [ ] Expected: Toast message "Added to favorite: [product name]"
- [ ] Icon should change color (visual feedback)

---

### 4. Layout & Styling
**Test Case 1: Colors**
- [ ] Search bar background: Light gray (#F5F5F5) ✓
- [ ] Product cards: White (#FFFFFF) with gray border ✓
- [ ] Prices: Red (#FF6B6B) ✓
- [ ] Banner background: Red (#FF6B6B) ✓

**Test Case 2: Text Size & Style**
- [ ] Search hint: "Tìm kiếm sản phẩm..." ✓
- [ ] Banner discount: Large 24sp bold text ✓
- [ ] Product name: 14sp bold ✓
- [ ] Product description: 12sp gray ✓

**Test Case 3: Responsiveness**
- [ ] Rotate device to landscape
- [ ] Expected: Layout adapts properly
- [ ] All text visible, no overlap

---

### 5. Sample Data Verification
**Banners:**
- [ ] Banner 1: "Khuyến mãi" - "Giảm 50%" - "Chỉ hôm nay"
- [ ] Banner 2: "Flash Sale" - "Giảm 40%" - "Tối nay"
- [ ] Banner 3: "Mua nhiều" - "Giảm 30%" - "Tuần này"

**Products (all 6 should be present):**
- [ ] Laptop Dell XPS - $999.99 - 4.5★
- [ ] iPhone 15 Pro - $1299.99 - 4.8★
- [ ] Samsung Galaxy Watch - $399.99 - 4.3★
- [ ] Sony WH-1000XM5 - $349.99 - 4.7★
- [ ] iPad Air - $599.99 - 4.6★
- [ ] MacBook Pro - $1999.99 - 4.9★

---

### 6. Combined Interactions
**Test Case 1: Search then Interact**
- [ ] Search for "laptop"
- [ ] Expected: Only Laptop product shown
- [ ] Click the product
- [ ] Expected: Toast "Product: Laptop Dell XPS"
- [ ] Click favorite button
- [ ] Expected: Toast "Added to favorite: Laptop Dell XPS"

**Test Case 2: Multiple Filters**
- [ ] Search "máy" (Vietnamese for machine)
- [ ] Expected: Laptop, iPad, MacBook shown (3 items)
- [ ] Click on iPhone (if visible from previous state)
- [ ] Clear search
- [ ] Expected: All 6 products back

**Test Case 3: Full Page Flow**
- [ ] Scroll to top (see search bar)
- [ ] See banner carousel
- [ ] Scroll down (see product list)
- [ ] Type search query
- [ ] Click products/banners
- [ ] Check all toast messages appear

---

## Expected Toast Messages

### Banner Clicks
```
"Clicked: Khuyến mãi"
"Clicked: Flash Sale"
"Clicked: Mua nhiều"
```

### Product Clicks
```
"Product: Laptop Dell XPS"
"Product: iPhone 15 Pro"
"Product: Samsung Galaxy Watch"
"Product: Sony WH-1000XM5"
"Product: iPad Air"
"Product: MacBook Pro"
```

### Favorite Clicks
```
"Added to favorite: Laptop Dell XPS"
"Added to favorite: iPhone 15 Pro"
... (for each product)
```

---

## Common Issues & Solutions

### Issue: RecyclerView not showing
**Solution:** 
- Check if layout IDs match (bannerRecyclerView, productRecyclerView)
- Verify adapters are initialized before setting
- Check if sample data is added

### Issue: Search not filtering
**Solution:**
- Verify SearchView ID is searchView
- Check OnQueryTextListener is set
- Ensure filterProducts() is called

### Issue: Banner not scrolling
**Solution:**
- Verify LinearLayoutManager is set to HORIZONTAL
- Check item width is 300dp
- Ensure parent width allows overflow

### Issue: Toast not showing
**Solution:**
- Check requireContext() is valid
- Verify Toast.LENGTH_SHORT duration
- Ensure click listeners are attached

### Issue: Styles not applied
**Solution:**
- Clear app cache and rebuild
- Check drawable files exist and have correct colors
- Verify layout IDs match drawable references

---

## Performance Testing

### Memory Usage
- [ ] App starts without lag
- [ ] Scrolling lists is smooth (60 fps)
- [ ] No memory leaks on orientation change
- [ ] Filtering is instant (< 100ms)

### UI Responsiveness
- [ ] Search responds immediately while typing
- [ ] Clicks register instantly
- [ ] No frozen UI during filtering
- [ ] Smooth animations on scroll

---

## Final Checklist Before Deployment

- [ ] All 7 files created successfully
- [ ] All 4 files updated correctly
- [ ] No compilation errors
- [ ] All layouts preview correctly in IDE
- [ ] Sample data loads on launch
- [ ] Search filtering works perfectly
- [ ] All click events trigger correctly
- [ ] Colors match design (#FF6B6B, #F5F5F5, etc.)
- [ ] Text sizes and styles correct
- [ ] Scrolling smooth (horizontal & vertical)
- [ ] Toast messages appear on interactions
- [ ] App runs without crashes
- [ ] UI looks good on different screen sizes
- [ ] Memory usage acceptable
- [ ] No lint warnings related to new code

---

**Testing Status:** Ready ✅
**Estimated Testing Time:** 15-20 minutes
**Test Date:** [Your Date]
**Tested By:** [Your Name]

