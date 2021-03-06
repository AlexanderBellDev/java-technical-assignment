# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

- Attempted to create an abstract class Discount, which has a constructor which takes in a basket of current items, and also a calculate method which needs to be overriden in all child classes 
  with different behaviour depending on what discount is being applied.
  
- DiscountCalculator static method used as a utility method to take in all the currently applied discounts, run through one by one and add to the total discount being applied at the end
- When discounts are applied to the basket, the basket class gives in a reference to the basket object so operations are able to be applied on them.
- Added java language level 9 for List.of()

Thanks for looking over my solution! Any feedback would be much welcomed :)