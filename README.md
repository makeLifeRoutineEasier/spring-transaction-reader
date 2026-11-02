📊 Transaction Reader
Java application for parsing, processing, and presenting transaction data in human readable format. 

It can be used in following:

💰 Track financial operations and present it
📝 Logging executed requests
📦 Process completed transactions for storage and further analysis 
🤖 Realize RPA to sequentially provide individual data units

⚙️ How It Works

The application follows a simple processing pipeline:

File validation — Check the file extension and determine whether the format is supported (JSON, CSV, or XML).

Field mapping — Map the input fields to the corresponding properties of the data model.

Parsing — Deserialize the file content into structured Java objects.

Result presentation — Convert the parsed data into a human-readable view.

🏗️ Architecture

The application uses the Strategy Design Pattern to organize file processing.
This approach provides:

Separation of file-format-specific logic.
Reduced coupling between the processing components.
Easier extension with additional formats.
Better maintainability and testability.

🧪 Testing

The application includes two integration tests covering its core processing functionality.

🛠️ Tech Stack
Java 17
Spring Framework
Jackson
Maven

🚀 Getting Started

Prerequisites

Java 17 or higher

Maven

Build the application

mvn clean install

Run the application

mvn spring-boot:run

Built with Java and Spring Framework.

Stack: Java 17, Spring Framework, Jackson, Maven


