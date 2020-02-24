# Retrofit_PUT_PATCH_DELETE_REQUEST
Retrofit  PUT, PATCH &amp; DELETE REQUEST


We will learn how to make PUT, PATCH and DELETE requests on a REST API.
PUT and PATCH are the HTTP methods that we use to update data on a server. 
While PATCH only changes the specific fields we send over, PUT completely replaces the existing entity with the one in the request body (or alternatively creates it).
A DELETE request deletes an existing resource.
PUT, PATCH and DELETE are usually applied on a single item rather than a collection as a whole.
As usual, we declare these methods in our API Java interface and annotate them with their corresponding HTTP call: @PUT, @PATCH or @DELETE. With @Path placeholders we dynamically specify the URL endpoint on which we want to modify a resource. PUT and PATCH both send a @Body annotated request body, which the GSON converter serializes into the JSON format. By calling serializeNulls on a GsonBuilder and passing the Gson instance to the GsonConverterFactory's create method in addConverterFactory, we can tell GSON to not drop null values in the serialzation process. Alternatively we can send single fields @FormUrlEncoded. 
DELETE returns a Call of type Void, with which we specify that we don't want to read the response body. A successful delete operation is indicated by a 200 (OK) response code.
As usual, we run our network requests on a background thread, by calling enqueue instead of execute, and handle the results in the onResponse and onFailure callbacks
