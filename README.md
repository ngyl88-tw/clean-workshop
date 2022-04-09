## Overall Requirement

Purchasing system
- As a user, I want to create a purchase request containing item, price and send it to the the manager
- As a mid-level manager, I want to automatically reject a purchase request which have a total price higher than 100,000 THB

---
### Exercises

#### Exercise 1
Assuming you are database team: Implement repository
For the sake of tutorial, we will use in-mem database (simple ArrayList)

**Check-in**:
- Align

#### Exercise 2
Assuming you are in domain team: Implement domain object and usecase
PurchaseRequest class
PurchaseRequest class with create method

- Domain requirement:
```
>= 100,000 THB must be approved by Senior Management
< 100,000 THB can be approved by both Senior and mid-level management
```

- Notes:
```
Employee → Add Level method

Steve is mid-level management “steve@microapplesoft.com”
Mark is senior management “mark@microapplesoft.com”
Others are just employee

PurchaseRequest use-case
- Create a purchase request domain object
- If success, save to repository

Remember Domain team does not know about Spring. It’s plain Java team.
In 90’s, every framework have licensing cost
```
```
- Employee level,
- PuchaseRequest.create
- PurchaseRequestUseCase.Create as an API for other team to consume
```