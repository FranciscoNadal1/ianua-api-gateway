# Ianua API Gateway

## Description

This is the repository for the Ianua API Gateway project. The project is functional and can redirect to specific URLs. 
However, there are many features that are still under development.

## Installation and Running the Project

To run this project, follow these steps:

1. Clone the repository: `git clone https://github.com/FranciscoNadal1/ianua-api-gateway.git`
2. Navigate to the project directory: `cd ianua-api-gateway`
3. Run the project: `docker compose up --force-recreate --build`

## Features Under Development

- **Aplication exceptions**: More exceptions should be added.
- **API Security**: The API for the gateway configuration is currently open and should be secured with a server-side token.
- **Database Calls**: The default database is MySQL, but it should not be called when redirecting to another endpoint.
- **Caching**: A cache should be added to maintain all this configuration for quick access.
- **Asynchronous Logging**: All accesses to a specific endpoint should be asynchronously logged.
- **Exception Logging**: Exceptions should be logged.
- **Input Format Validation**: Input formats should be validated.
- **Format Mapping**: Mapping between different formats, both between JSON and from JSON to XML, should be added.
- **Complex Mapper**: A complex mapper to change JSON to another structure should be added.
- **Custom Headers**: The ability to add custom headers should be added.
- **Load Balancing**: The possibility of load balancing to multiple servers of the same endpoint should be added.

## Improvements Needed

- **Code Quality**: The quality of the code needs to be improved.
- **Exception Handling**: More diverse exceptions should be added.
- **API Definition**: The definition of the API needs significant improvement. This includes adding OpenAPI v3 documentation.
- **JSON:API Convention**: The project should comply with the JSON:API convention.

## Contributing

Contributions are welcome. To contribute:

1. Fork the project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
