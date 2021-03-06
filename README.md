# Restful Invoice API with Spring Boot (Java) and Postgres
### Postgres Setup

From command line run 
1. `createuser -h localhost -p 5432 -U postgres -d -l -S postgres`
1. Change <POSTGRES_HOME>/data/pg_hba.conf from _md5_ -> _trust_ to allow passwordless entry
    - OPTIONAL use `pg_ctl reload` if already running
1. `createdb -U postgres invoices`
1. `psql -U postgres invoices`
1. Run the following sql command in prompt to create the table 

        CREATE TABLE invoices (
        id SERIAL,
        invoice_number VARCHAR(64) NOT NULL,
        po_number VARCHAR(64) NOT NULL,
        due_date DATE NOT NULL,
        amount_cents BIGINT NOT NULL,
        created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
        );

### Running the application
1. cd into home directory of source code
1. `mvn clean install`
1. `java -jar target\rest.0.0.1-SNAPSHOT.jar` or use `mvn spring-boot:run`

### How to use endpoints
###### CREATE INVOICE
`curl -d "invoice_number=ABC12345&po_number=X1B23C4D5E&due_date=2017-03-15&amount_cents=100000" -H "Content-Type: application/json" -X POST http://localhost:8080/v1/invoices`

###### SEARCH BY INVOICE NUMBER
`curl -X GET http://localhost:8080/v1/invoices?invoice_number=ABC12345&page=0&limit=1`

###### SEARCH BY PO NUMBER
`curl -X GET http://localhost:8080/v1/invoices?po_number=X1B23C4D5E&page=0&limit=1`

__Note__: If both invoice number and PO number are given, endpoint will return search by invoice number.
