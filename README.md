# Send SMS

This is a Spring Boot application designed to send SMS messages using the Twilio API. It exposes a simple REST endpoint to receive a destination phone number and a message, which it then forwards via a configured Twilio account.
<div align="left">
  <img src="https://skillicons.dev/icons?i=java" height="40" alt="java logo"  />
  <img width="12" />
  <img src="https://skillicons.dev/icons?i=spring" height="40" alt="spring logo"  />
  <img width="12" />
  <img src="https://skillicons.dev/icons?i=maven" height="40" alt="apachemaven logo"  />
</div>

## Prerequisites

Before you can run this application, you will need the following:
*   Java 21 or later
*   Maven
*   A Twilio account. You will need:
    *   Your Account SID
    *   Your Auth Token
    *   A Twilio phone number (for sending SMS)

## Configuration

1.  Clone the repository:
    ```sh
    git clone https://github.com/konradxmalinowski/Send-SMS.git
    cd Send-SMS
    ```

2.  Update the configuration file `src/main/resources/application.properties` with your Twilio credentials.

    ```properties
    spring.application.name=Send SMS
    TWILIO_ACCOUNT_SID=ACxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    TWILIO_AUTH_TOKEN=your_auth_token
    TWILIO_OUTGOING_SMS_NUMBER=+15017122661
    ```
    
    Alternatively, you can set these values as environment variables, which is recommended for production environments. The application will automatically pick them up.

## Running the Application

You can build and run the application using the included Maven wrapper:

```sh
./mvnw spring-boot:run
```

The application will start on the default port `8080`.

## API Usage

To send an SMS, make a `POST` request to the `/api/v1/processSMS` endpoint.

**Endpoint:** `POST /api/v1/processSMS`

**Request Body:**

The request body must be a JSON object containing the destination number and the message.

```json
{
    "destinationSMSNumber": "+1234567890",
    "message": "Hello from the Send SMS application!"
}
```

**Example using cURL:**

Replace `+1234567890` with the recipient's phone number in E.164 format.

```sh
curl -X POST \
  http://localhost:8080/api/v1/processSMS \
  -H 'Content-Type: application/json' \
  -d '{
        "destinationSMSNumber": "+1234567890",
        "message": "Hello from the Send SMS application!"
      }'
```

**Successful Response:**

The API will return the status of the message creation process from Twilio, such as `queued` or `sending`.

```
queued
