# MessageProcessing

**THE PROBLEM:**
Implement a small message processing application that satisfies the below requirements for processing sales
notification messages. You should assume that an external company will be sending you the input messages,
but for the purposes of this exercise you are free to define the interfaces. Incoming messages can be read
from a text file, following the format of the example messages from bellow.

**Processing requirements:**
1. All sales must be recorded.
2. All messages must be processed.
3. After 10messages have been received your application should log that it is pausing, stop accepting
   new messages and log a report detailing the number of sales of each product and their total value.

**SALES AND MESSAGES**
1. A sale has a product type field and a value – you should choose sensible types for these.
2. Any number of different product types can be expected. There is no fixed set.
3. A message notifying you of a sale could be one of the following types:
   I. Message Type 1 – contains the details of 1 sale e.g., apple at 10p
   II. Message Type 2 – contains the details of a sale and the number of occurrences of that sale.
      e.g., 20 sales of apples at 10p each.

**Running Application**
1. Go to /daily-trade-report/src/main/java/com/trading/DailyTradeReportApplication.java
2. Run as Java application ->   DailyTradeReportApplication.java