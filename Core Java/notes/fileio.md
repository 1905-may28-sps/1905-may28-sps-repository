# file io
* ability to read and write files

# Character stream
* human readable text
* `FileReader`
* `FileWriter`

# Byte stream
* machine readable text
* `FileInputStream`
* `FileOutputStream`

# Buffered stream
* it is costly to read/write a single character/byte at a time
* buffer allows you to read/write large chunks at a time
* `BufferedReader`, `BufferedWriter`
* `BufferedInputStream`, `BufferedOutputStream`

# Serialization
* convert Java object to byte stream
* what is **deserialization**?
* `ObjectInputStream`, `ObjectOutputStream`
* **is a** `Serializable`
  * `Serializable` is a **marker interface**
* **serialVersionUID** - defines the version of the class
* `transient` variables will not be serialized

# Marshaling
* convert object to language agnostic data format: xml, json, yaml, ...
* what is **unmarshaling**?

# Fun fact
* first 4 bytes of every `.class` file is CAFEBABE in hex

# try with resources
* automatically close a resource
* **is a** `AutoCloseable`
