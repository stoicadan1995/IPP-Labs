# Laboratory Work 1-3 for Design Patterns 

## Laboratory Work 1: Creational Patterns

Creational patterns **encapsulate knowledge about concrete classes** the system use, **hide how instances of these
classes are created** and **separate the system from how the objects are composed and represented**.

- **Abstract Factory** <br/>
**What**. Abstract Factory provides an interface for creating families of related/dependent objects without specifying
their concrete classes. Abstract Factory abstracts and encapsulates the creation of a suite of products for a given
platform/family that the system depends on<br/>
**How**. `AbstractFactory` interface provides methods for creating all kinds of products for a given
platform/family. Client works only with the `AbstractFactory` and the `Product` interfaces. The concrete
implementations of the `AbstractFactory` interface are singletons<br/>
**Example**. The system depends on a `Letter`=`Product` and a `Resume`=`Product` instances. The system uses a
`DocumentCreator`=`AbstractFactory` for creating the concrete `Letter` and `Resume` instances from the two families:
modern and fancy

- **Builder** <br/>
**What**. Builder separates a construction of a complex object from its representation, allowing the same construction
step by step process to create various representations<br/>
**How**. Client uses **(a)** a separate `Builder` object which receives each initialization parameter step by step
in a fluent interface or **(b)** a `Builder` DSL initialization method which configures properties by direct property
assignment or function call and returns the resulting constructed complex object at once<br/>
**Example**. `Car.Builder` provides a builder DSL (`Car.build { ... }`) for building a `Car` instance

- **Factory Method** <br/>
**What**. Factory method defines an interface for creating a single object, but let subclasses decide which class to
instantiate<br/>
**How**. `FactoryMethod` interface provides a method for creating a single object. Client works only with the
`FactoryMethod` and the `Product` interfaces. The concrete implementations of the `FactoryMethod` interface are
singletons<br/>
**Example**. The system depends on an `Article`=`Product` instances. The system uses `ArticleCreator`=`FactoryMethod`
for creating a single `Article` instance from the two families: modern and fancy


## Laboratory Work 2: Structural Patterns

Structural patterns provide simple way of implementing **relationships between objects**.

- **Adapter** <br/>
**What**. Adapter converts the interface of the class without modifying class code into another interface that client
expects<br/>
**How**. Client works with the class through an implementation of the `Adapter` interface that client expects and
delegation to the class methods<br/>
**Example**. Client expects the `Phone`=`Adapter` interface. `XiaomiPhoneAdapter` implements the `Phone` interface that
client expects and delegates to the `XiaomiPhone` class methods

- **Bridge** <br/>
**What**. Bridge decouples an abstraction from its implementation (two orthogonal dimensions) allowing the two to vary
independently<br/>
**How**. The `Abstraction` and its `Implementation` are defined and extended independently. The `Abstraction` is
implemented by delegating to its `Implementation`<br/>
**Example**. The `Device`=`Abstraction` has two implementations `PhoneDevice` and `TabletDevice`. The
`Vendor`=`Implementation` has two implementations `XiaomiVendor` and `NokiaVendor`. The `Device` implementations accept
`Vendor` implementation. The `Device::switchOn()` method delegates to the `Vendor::support(Device)` method

- **Decorator** <br/>
**What**. Decorator attaches additional behavior to an individual object dynamically keeping the same interface without
affecting the behavior of other objects of the same class<br/>
**How**. The `Decorator` class implements the original `Component` interface by delegating the request to the original
object and adding behavior before/after the original request. Multiple decorators can be stacked on top of each
other<br/>
**Example**. The `SimpleCoffee` original class implements the `Coffee`=`Component` interface. The
`CoffeeWithSugar`=`Decorator` and the `CoffeeWithMilk`=`Decorator` decorators implement the `Coffee` interface and
accept the `Coffee` instance to delegate to

## Laboratory Work 3: 4 Design Patterns

- **Chain of Responsibility** <br/>
**What**. Chain of Responsibility chains the receiving objects/functions (handlers) and pass the request along the chain
until an object/function handles the request completely or partially. Avoids coupling of the request sender to the
request receiver allowing more than one receiver a chance to handle the request<br/>
**How**. The `Request` represents the initial data, then intermediary results and finally the final result. The
`RequestHandler` functional interface processes the `Request` partially or completely. The `ChainOfResponsibility`
composes the `RequestHandler`s and implements the `RequestHandler` functional interface to process the `Request`
**Example**. The `cashRequestHandlerChain`=`ChainOfResponsibility` composes the `CashRequestHandler`=`RequestHandler`
and implements the `RequestHandler` interface to process the `CashRequest`=`Request`. The `CashRequest` has the initial
amount to represent with the set of notes. The `CashRequest` is used to handle intermediary results by representing the
remaining amount and a set of already processed notes. The `CashRequest` finally represent the final result of the set
of notes with the amount remainder if any

- **Command** <br/>
**What**. Command encapsulates an action with the request parameters as an function/object and decouples the request for
an action from the actual action performer. Allows action/request queueing, logging and undoable operations<br/>
**How**. The `Command` object stores the request parameters and delegates the request to the `Receiver` which performs
the action. The `Invoker` object uses the `Command` interface and provides request queueing, logging and undoable
operation functionality<br/>
**Example**. The `cookStarter()`, `cookMainCourse()` and `cookDessert()` functions implement the
`Order`=`Command`=`Receiver` interface and store the request arguments in a closure. The `Waiter`=`Invoker` queues the
`Order`s and serves the `Order`s by using the `Order` interface

- **Interpreter** <br/>
**What**. Given a language (DSL), defines a language grammar with an interpreter that use the grammar to interpret the
language sentences<br/>
**How**. Defines an `Expression` class hierarchy for each `TerminalExpression` and `NonterminalExpression` symbol in the
language. The abstract syntax tree (AST) of the language sentence is a `Composite` of `Expression`s and is used to
evaluate the sentence. The `TerminalExpression` interprets the expression directly. The `NonterminalExpression` has a
container of children `Expression`s and recursively interprets every child `Expression`. Interpreter does not describe
how to build an AST. The AST can be build with a parser<br/>
**Example**. The `Constant`=`TerminalExpression`, the `Add`=`NonterminalExpression` and the
`Mul`=`NonterminalExpression` implement the `Expression` interface. The `Interpreter` implements the `Expression`
interpretation algorithm

- **Iterator** <br/>
**What**. Iterator provides a way to access the elements of an aggregate object/container of components sequentially
without exposing aggregate underlying representation (data structure). Iterator encapsulates the traversal algorithm of
a given aggregate object/container of components<br/>
**How**. The `ContainerIterator` implements the `Iterator` interface for the `Container` of `Component`s to traverse
sequentially the `Component`s of the `Container` without exposing the underlying aggregate representation. Client access
the `Component`s of the `Container` only through the `Iterator` interface<br/>
**Example**. The `FruitsIterator`=`ContainerIterator` implements the `Iterator` interface for the `Fruits`=`Container`
of `Fruit`=`Component`
