# FinancePal: Expense Management System

Welcome to 'FinancePal', an Expense Management System designed to simplify financial tracking and streamline expense management. This web application is built using Kotlin, KVision, Ktor, and MySQL, providing a robust and intuitive solution for individuals and businesses to manage their expenses efficiently.

## Features

- **Expense Tracking:** Easily log and categorize your expenses for accurate financial monitoring.

- **Budget Management:** Set budgets for different categories and track your spending to stay within financial goals.

- **Real-time Updates:** Receive real-time updates on your financial status and spending patterns.

- **User-Friendly Interface:** Enjoy a clean and intuitive user interface for a seamless user experience.

- **Secure Authentication:** Ensure the security of your financial data with robust user authentication mechanisms.

## Technologies Used

- **Backend:** Kotlin, Ktor
- **Frontend:** KVision
- **Database:** MySQL

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/financepal.git
   ```

2. Set up the database:

   - Create a MySQL database and update the connection string in the `application.conf` file.

   ```ini
   database {
       driver = "com.mysql.cj.jdbc.Driver"
       url = "jdbc:mysql://localhost:3306/your_database"
       user = "your_username"
       password = "your_password"
   }
   ```

3. Build and run the application:

   ```bash
   ./gradlew build
   java -jar build/libs/financepal.jar
   ```

4. Access the application in your web browser at `http://localhost:8080`.

## Contributing

We welcome contributions from the community! If you'd like to contribute to FinancePal, please follow our [contribution guidelines](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE.md).

## Support

For any issues or questions, please [open an issue](https://github.com/your-username/financepal/issues) on GitHub.

---

Thank you for choosing FinancePal for your expense management needs. We hope this tool helps you gain better control over your finances. If you have any feedback or suggestions, feel free to reach out. Happy budgeting!
