 - Our stereotypical powerful developer always has an interface for a class. That's so much more flexible!
 - RMI is good as it gives you type safety. SOAP is also nice. Surely not all powerful developers like SOAP, but you'll
   never know: maybe some of the clients is written in a different programming language or likes to use a SOAP binding
   for a different reason. So better provide both RMI and SOAP.
 - An interceptor is used for logging. Interceptors are cool.
 - In production the statistical data based on age and gender is read from a database. This is much more flexible as you 
   can change the data at runtime without having to redeploy. There is an additional implementation with an in-memory 
   approach for testing purposes. 
   
   
ToDo:
 - introduce the abstraction of personal attributes when height and weight come into play