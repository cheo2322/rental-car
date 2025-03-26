# Rental Car web service

## First Tasks

- Create Roles (DB level)

## User Stories

- **US1** : As a new Client, I would like to be registered in the system :white_check_mark:

  **Endpoints** : POST Person, POST Client, POST License :link:

  **TD** : Upload photo for client. Upload photo for license. Ask for interests to the client :hammer_and_wrench:

- **US2**: As an admin, office admin, rental agent or private car owner, I would like to add a Brand, a Model and a
  Category to be eligible for a Car :white_check_mark:

  **Endpoints** : POST Brand, POST Model, POST Category :link:

  **TD** : Upload logo for brand. Add the addedByEmployeeId field. Create identifiers instead of look for the whole
  names :hammer_and_wrench:

- **US3** : As an admin, office admin or car owner, I would like to add a Car from the company :white_check_mark:

  **Endpoints** : POST Car

  **TD** : Check the role in order to add the attributes. Condition ? . Add photos for Car :hammer_and_wrench:

- **US4** : As a registered Client, I would like to rent a selected Car :white_check_mark:

  **Endpoints** : POST CreateRentRecord

  **TD** : Add the business responsible. Read the Client ID from Spring Security. Create a way to reserve Car before to
  pay, in order to avoid crashes

- **US#** : As a registered Client, I would like to filter Cars by brand :rocket:
- **US#** : As a private Car Owner, I would like to register my car to be rented by the company :rocket:
- **US#** : As an Admin, I would like to be registered in the system :rocket:
- **TD** : Create exception handler. Perform operations depending on roles :hammer_and_wrench:

## Glossary

- US<int>: User story (i.e. US1, US2, ...)
- BF: Bug fix
- TODO: To Do
- IM: Improvement
- NAT: Not a Task
- TD: Technical Debt
- RM: Readme
