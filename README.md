**Running app:**
- Download (or clone) app to local machine.
- Open it in IDE, import maven dependency and run InvoiceServiceApplication.main()
  - Or
- Go to app folder, run "mnv package" command, next run the "java -jar target/za.co.digitalplatoon.invoiceservice-1.0-SNAPSHOT.jar"


**API:**
- Add Invoice  POST http://localhost:8080/invoices
- View All invoices  GET http://localhost:8080/invoices
- View Invoice  GET http://localhost:8080/invoices/{invoiceId}
- Swagger-ui  http://localhost:8080/swagger-ui.html
- H2 ui  http://localhost:8080/h2