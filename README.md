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

  **TD** : Upload logo for brand. Add the addedByEmployeeId field :hammer_and_wrench:

- **US3**: As an office admin, I would like to add a Car from the company :hourglass:

- **US#** : As a registered Client, I would like to filter Cars by brand :rocket:
- **US#** : As a private Car Owner, I would like to register my car to be rented by the company :rocket:
- **US#** : As an Admin, I would like to be registered in the system :rocket:
- **TD** : Create exception handler :hammer_and_wrench:

## Glossary

- US<int>: User story (i.e. US1, US2, ...)
- BF: Bug fix
- TODO: To Do
- IM: Improvement
- NAT: Not a Task
- TD: Technical Debt
- RM: Readme
