# 📊 Transaction Reader  
Java application for parsing, processing, and presenting transaction data in human readable format.   
  
### Can be used in following:  
💰 Track financial operations and present it  
📝 Logging executed requests  
📦 Process completed transactions for storage and further analysis    
🤖 Realize RPA to sequentially provide individual data units  

### ⚙️ How It Works    
The application follows a simple processing pipeline:  
| Step | Description |
|---|---|
| File Validation | Checks the file extension and determines whether the format is supported (JSON, CSV, or XML). |
| Field Mapping | Maps input fields to the corresponding properties of the data model. |
| Parsing | Deserializes file content into structured Java objects. |
| Result Presentation | Converts parsed data into a human-readable view. |

### 🏗️ Architecture  
The application uses the Strategy Design Pattern to organize file processing.    
This approach provides:    
- Separation of file-format-specific logic.
- Reduced coupling between the processing components.
- Easier extension with additional formats.
  
### 🧪 Testing    
The application includes two integration tests covering its core functionality.    
  
### 🛠️ Tech Stack  
Java 17  
Spring Framework  
Jackson  
Maven  

### 🚀 Getting Started  
Install dependencies  
`mvn clean install`
  
Run the application    
`mvn spring-boot:run`  




