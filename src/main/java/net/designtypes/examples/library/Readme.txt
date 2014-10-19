This is the setting:
 - In a small insurance company a library is used to compute the life expectancy of insurees
 - The influencing factors and computation formulas change frequently. Currently the computation is based on age, gender 
   and smoking habits. (The company is based in a country where it is legal to distinguish between gender here.) 
 - The company and thus the software ecosystem is growing. Several systems use the library but have to be upgraded 
   frequently to new versions of the library.
 - To avoid these problems in future the company moves towards a service-oriented approach. This move started around 
   five years ago and will probably take another fife years to complete. This means there are already some services 
   around but there are also several legacy systems which will evolve into services in the next years.
 - One of the services which are already there is the InsureeDataService. Given an insuree number it provides 
   information on the insuree. 
   
Goal:
 - The library is to be converted into a service so it can be used by other services.
 - Management has already decided to include the insuree's height and weight into the calculation 