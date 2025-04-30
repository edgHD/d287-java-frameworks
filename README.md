# WESTERN GOVERNORS UNIVERSITY
## D287 – JAVA FRAMEWORKS

### Part C:
> CHANGED mainscreen.html:
> - Most of the lines: I changed the customer from a Bicycle Shop to Sweet Delights Bakery, including titles and vocabulary (check commit for more details)
> - Lines 14-15: Linked the file to the new global.css style
> - Lines 22-23: Added bakery icons (🥐 and 🍰) to the main heading for better visual identity
> - Lines 25-38 and 60-71: Improved search bar with clearer labels and placeholders for ingredient and goods search
> - Lines 99-101: Added a simple footer
>
> ADDED global.css:
> - Lines 1-180: Added an approaching styling for Sweet Delights Bakery's website

### Part D:
> ADDED about.html:
> - Lines 1-156: Wrote entire page about Sweet Delights Bakery's business
>
> CHANGED mainscreen.html:
> - Lines 24-30: Added a Navigation to give access to the About page
> - Lines 108-110: Added a direct link to the About page
>
> CHANGED MainScreenController.java:
> - Lines 55-58: I mapped the URL path for About page
> 
> CHANGED global.css:
> - Lines 91-119: Added style for outline buttons

### Part E:
> CHANGED BootStrapData.java:
> - Line 3: Imported com.example.demo.domain.InhousePart
> - Lines 77-124: Added sample bakery inventory with five ingredients and five goods to initialize the set when empty

### Part F:
> CHANGED mainscreen.html:
> - Lines 83-103: Added a script to show the appropriate alert for each purchase request
> - Line 119: Added class 'product-inventory' on table data for better handling the script
> - Line 123: Added 'Buy Now' button
> 
> CHANGED MainScreenController.java:
> - Lines 13-16 and 19-20: I imported the necessary packages
> - Lines 65-94: Added a new 'BuyProduct' endpoint that decrements inventory when a good is purchased and also handles response output

### Part G:
> CHANGED Part.java:
> - Line 7: I imported Max validation constraint
> - Lines 32-35: Added minInv and maxInv fields with proper validation constraints
> - Lines 87-92: Modified setInv() method to enforce min/max inventory constraints
> - Lines 96-111: Added getters and setters for new minimum and maximum inventory fields
>
> CHANGED mainscreen.html:
> - Lines 52-53: Added 'Minimum' and 'Maximum' columns to the Ingredients table header
> - Lines 62-63: Added display of minInv and maxInv values in table rows
>
> CHANGED InhousePartForm.html:
> - Lines 31-36: Added input field for minimum and maximum inventory with validation error display
>
> CHANGED OutsourcedPartForm.html:
> - Lines 32-37: Added input field for minimum and maximum inventory with validation error display
>
> CHANGED BootStrapData.java:
> - Lines 78-112: Updated all sample ingredient data to include minInv=1 and maxInv=100
>
> CHANGED application.properties:
> - Line 6: Changed database filename to 'sweet-delights-inventory' for persistent storage

### Part H:
> ADDED ValidInventory.java:
> - Lines 1-17: Created a custom constraint annotation for validating inventory ranges
>
> ADDED InventoryValidator.java:
> - Lines 1-62: Implemented a validator that checks if inventory ranges stay within minimum and maximum limits
>
> CHANGED Part.java:
> - Lines 4 and 21: I integrated ValidInventory for centralized validation logic
> - Line 34: Ensuring minimum inventory is positive (>= 1)
> - Lines 87-92: Refactored the setInv(), setMinInv(), and setMaxInv() methods to rely on InventoryValidator.java
>
> CHANGED ValidEnufParts.java:
> - Line 20: Updated default error message for clarity

### Part I:
> CHANGED PartTest.java:
> - Lines 159-176: Added two unit tests for the maximum and minimum fields

### Part J:
> REMOVED the following unused validator classes:
> - ValidDeletePart.java
> - DeletePartValidator.java
> - ValidProductPrice.java
> - PriceProductValidator.java
> 
> CHANGED Product.java:
> - Lines 4 and 20: Removed import and annotation from removed ValidProductPrice class
> 
> CHANGED Part.java:
> - Lines 3 and 20: Removed import and annotation from removed ValidDeletePart class