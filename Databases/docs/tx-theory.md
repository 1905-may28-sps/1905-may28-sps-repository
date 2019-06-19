# transaction (tx) theory

# ACID
* **Atomic** - all or nothing
* **Consistency** - bring the database from one valid state to another
* **Isolation** - concurrent tx run the same as sequential tx
* **Durability** - once a tx is committed, it will remain so
  * usually this refers to hardware failures

# Tx Isolation Levels

in order from least restrictive to most restrictive

* read uncommitted
* read committed
* repeatable read
* serializable

# When bad things happen
* dirty read
* non-repeatable read
* phantom read

# Tx Propagations

defines the tx scope (also called *tx attributes*)

* Required
* Requires_new
* Supports
* Not_supported
* Mandatory
* Never
