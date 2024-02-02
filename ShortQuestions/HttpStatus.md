### `1xx` informational

They inform the client that the request is still in progress and provide information about its current state, rather than indicating finality

##### **100 Continue**

- the initial part of a request has been received and has not yet been rejected by the server. The server intends that the client should continue with the request or ignore it if it is already finished.

##### **103 Early Hints**

- preload resources while the server is still preparing a response for a request

### `2xx` success

##### **200 OK**

- the request was successfully processed and the response contains the resulting payload. 

##### **201 Created**

- POST 

##### **202 Accepted**

- the request has been accepted for processing, but the processing is not yet complete. The actual outcome of the request is not known
- often used for requests that involve a significant amount of processing time or are processed asynchronously.

##### **204 No Content**

- the server successfully processes the request, but does not need to return any content.
- DELETE requests.

##### **205 Reset Content**

- he server successfully processed the request and wants the client to reset the document view, useful for updating forms or user interfaces.

##### **206 Partial Content**

- the server is fulfilling a range request for a document. It's useful for resuming interrupted downloads, or splitting a download into multiple simultaneous streams.

### `3xx` redirection.

##### 302 Found

- redirection
- the resource requested by the client has been temporarily moved to a different URI 
-  it also provides the new URI in the response headers. 

##### 



### `4xx` client errors.

### `5xx` server errors.

