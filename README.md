Start server
```
gradle run
```
There is proper bean validation on this endpoint:
```
curl localhost:8080/asyncok
{"_links":{"self":{"href":"/asyncok","templated":false}},"message":"t.text: must not be blank"}
```
...and this endpoint:
```
curl localhost:8080/syncok
{"_links":{"self":{"href":"/syncok","templated":false}},"message":"t.text: must not be blank"}
```
...but not on these endpoints:
```
curl localhost:8080/asyncnotok
{}
curl localhost:8080/syncnotok
{}
```
