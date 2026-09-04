---
title: "Chapter 2 — Encapsulation"
date: 2026-09-02
tags:
  - Java
  - Software Design
  - Encapsulation
  - Immutability
  - Records
  - Design by Contract
---

# Chapter 2 — Encapsulation

Chapter 2 focuses on **encapsulation**: designing classes so that their internal data and implementation are protected from other parts of the program.

The chapter uses a **deck of playing cards** as its main example.

---

# 1. Encapsulation

Encapsulation means placing data and behavior inside a controlled boundary.

For example:

```java
public class Card {
    private Rank aRank;
    private Suit aSuit;
}
```

Other classes should not be able to freely modify `aRank` or `aSuit`.

The goal is to make an object:

- easier to understand
- harder to misuse
- easier to change internally
- less dependent on other parts of the program

A well-encapsulated class controls how other code interacts with it.

---

# 2. Information Hiding

**Information hiding** means exposing only the information that other code actually needs.

For example, suppose a `Deck` internally stores its cards using an `ArrayList`:

```java
public class Deck {
    private List<Card> aCards = new ArrayList<>();
}
```

Other classes should not need to know that `ArrayList` is being used.

They should interact with the deck through methods such as:

```java
deck.draw();
deck.isEmpty();
```

This allows the implementation to change later without affecting client code.

---

# 3. Interface vs Implementation

In this chapter, **interface** does not necessarily mean the Java `interface` keyword.

An interface means:

> The part of a class that outside code is allowed to use.

For example:

```java
public class Card {
    private Rank aRank;
    private Suit aSuit;

    public Card(Rank pRank, Suit pSuit) {
        aRank = pRank;
        aSuit = pSuit;
    }

    public Rank rank() {
        return aRank;
    }

    public Suit suit() {
        return aSuit;
    }
}
```

The public interface contains:

```text
Card(...)
rank()
suit()
```

Client code can use them:

```java
Card card = new Card(Rank.ACE, Suit.HEARTS);

card.rank();
card.suit();
```

But the fields:

```java
aRank
aSuit
```

are private implementation details.

## Implementation

The **implementation** means:

> How the class actually works internally.

For example:

```java
private List<Card> aCards = new ArrayList<>();
```

Using an `ArrayList` is an implementation decision.

Client code should only care about:

```java
deck.draw();
```

It should not need to know whether the deck internally uses:

```java
ArrayList<Card>
```

or:

```java
Card[]
```

Therefore:

```text
Interface
= what outside code can do

Implementation
= how the class does it internally
```

Good encapsulation tries to hide implementation details behind a small interface.

---

# 4. Use the Narrowest Possible Scope

Class fields should normally be `private`.

Prefer:

```java
private Rank aRank;
```

instead of:

```java
public Rank aRank;
```

If the field is public:

```java
card.aRank = Rank.KING;
```

any client code can directly modify it.

If it is private:

```java
private Rank aRank;
```

only methods inside the class can access it directly.

This gives the class control over its own state.

---

# 5. Constructor

A **constructor** is special code that runs when a new object is created.

Example:

```java
public class Card {
    private Rank aRank;
    private Suit aSuit;

    public Card(Rank pRank, Suit pSuit) {
        aRank = pRank;
        aSuit = pSuit;
    }
}
```

The constructor is:

```java
public Card(Rank pRank, Suit pSuit) {
    aRank = pRank;
    aSuit = pSuit;
}
```

When we write:

```java
Card card = new Card(Rank.ACE, Suit.HEARTS);
```

Java roughly performs:

```text
1. Create a new Card object

2. Call the constructor with:

   pRank = Rank.ACE
   pSuit = Suit.HEARTS

3. Run:

   aRank = pRank
   aSuit = pSuit

4. The Card object is ready
```

The resulting object contains:

```text
aRank = ACE
aSuit = HEARTS
```

## Constructor Rules

A constructor:

- has the same name as the class
- has no return type
- runs when `new` is used

Correct:

```java
public Card(Rank rank, Suit suit) {
}
```

This is **not** a constructor:

```java
public void Card(Rank rank, Suit suit) {
}
```

because adding `void` makes it a normal method.

## Constructors and Encapsulation

Constructors can control what kinds of objects are allowed to be created.

For example:

```java
public Card(Rank rank, Suit suit) {
    if (rank == null || suit == null) {
        throw new IllegalArgumentException();
    }

    aRank = rank;
    aSuit = suit;
}
```

Now this cannot successfully create a card:

```java
new Card(null, Suit.HEARTS);
```

The constructor therefore acts as a kind of gatekeeper for object creation.

---

# 6. Avoiding Primitive Obsession

**PRIMITIVE OBSESSION†** is the tendency to use basic data types to represent concepts that deserve their own abstractions.

For example, we could represent cards using integers:

```java
int card = 13;
```

and create a convention such as:

```text
0  = Ace of Clubs
1  = Two of Clubs
...
13 = Ace of Hearts
```

This technically works, but it creates several problems.

When we see:

```java
int card = 13;
```

the type `int` does not tell us what `13` represents.

It could be:

```text
age
quantity
score
ID
playing card
```

Java also allows:

```java
int card = 999999;
```

even though that is not a valid card.

Instead, define a proper abstraction:

```java
Card card;
```

Now the type itself communicates the meaning.

---

# 7. Using Enums

A card is completely described by:

- its rank
- its suit

These values come from small, fixed sets.

Therefore, Java `enum` works well:

```java
enum Suit {
    CLUBS,
    DIAMONDS,
    SPADES,
    HEARTS
}
```

and:

```java
enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}
```

Then:

```java
class Card {
    private Rank aRank;
    private Suit aSuit;
}
```

Creating a card becomes:

```java
new Card(Rank.ACE, Suit.HEARTS);
```

This is much clearer than:

```java
13
```

A useful question is:

> Do not only ask, "What Java type can store this value?"

Also ask:

> "What concept does this value represent?"

If the concept matters to the program, creating a dedicated type can make the design clearer and safer.

---

# 8. Records

Java `record` provides a shorter way to create classes whose main purpose is to represent a fixed group of related values.

Consider:

```java
public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }
}
```

Java allows us to replace much of this with:

```java
public record Card(Rank rank, Suit suit) {}
```

Java automatically provides things such as:

```text
constructor
rank()
suit()
equals()
hashCode()
toString()
```

Therefore:

```java
Card card = new Card(Rank.ACE, Suit.HEARTS);
```

works.

And:

```java
card.rank();
card.suit();
```

also works.

---

# 9. When Should a Record Be Used?

Records are especially useful when an object mainly represents a **fixed collection of values**.

For example:

```java
public record Point(int x, int y) {}
```

or:

```java
public record Dimension(int width, int height) {}
```

or:

```java
public record Card(Rank rank, Suit suit) {}
```

Instead of passing:

```java
int width;
int height;
```

we can create:

```java
Dimension dimension;
```

This explicitly represents the concept of a dimension.

A simple rule:

```text
Mostly represents data/value
→ record may be appropriate

Complex changing state and behavior
→ normal class is often more appropriate
```

This is not an absolute rule. Records can also contain methods and additional constructors.

---

# 10. Object Diagrams

An **object diagram** is a UML diagram showing objects and the references between them at a particular moment during program execution.

For example:

```text
Deck
 |
 v
ArrayList<Card>
 |
 +----> Card
 |
 +----> Card
```

The diagram can show:

- objects
- fields
- primitive values
- references between objects

It represents a **snapshot** of the program rather than the complete execution.

---

# 11. Escaping References

Making a field `private` does not automatically guarantee encapsulation.

Consider:

```java
public class Deck {
    private List<Card> aCards = new ArrayList<>();

    public List<Card> cards() {
        return aCards;
    }
}
```

The field itself is private.

However:

```java
List<Card> cards = deck.cards();
```

now gives client code a reference to the same list.

The client could do:

```java
cards.add(new Card(Rank.ACE, Suit.HEARTS));
```

Now the internal state of `Deck` was modified without using a `Deck` method.

This is called an **escaping reference**.

Conceptually:

```text
Deck
  |
  v
[A, B, C]
  ^
  |
client code
```

Both `Deck` and the client hold references to the same mutable list.

---

# 12. Inappropriate Intimacy

A design where classes have too much access to each other's internal details is called:

**INAPPROPRIATE INTIMACY†**

For example, if every class constantly accesses another object's internal fields using getters and setters, the abstractions may not be properly separated.

Objects should normally communicate using meaningful operations instead of manipulating each other's internal state.

---

# 13. Immutability

An **immutable object** cannot change after it has been created.

For example:

```java
public class Card {
    private final Rank aRank;
    private final Suit aSuit;

    public Card(Rank pRank, Suit pSuit) {
        aRank = pRank;
        aSuit = pSuit;
    }

    public Rank rank() {
        return aRank;
    }

    public Suit suit() {
        return aSuit;
    }
}
```

After:

```java
Card card = new Card(Rank.ACE, Suit.HEARTS);
```

the object remains:

```text
ACE of HEARTS
```

for its lifetime.

There is no method such as:

```java
setRank(...)
setSuit(...)
```

that can modify it.

Because the fields are private, client code also cannot do:

```java
card.aRank = Rank.KING;
```

---

# 14. What Does `final` Do?

We can declare fields:

```java
private final Rank aRank;
private final Suit aSuit;
```

`final` means that once the field is assigned, its reference cannot later be reassigned.

For example:

```java
aRank = pRank;
```

happens during construction.

Afterward, code cannot simply do:

```java
aRank = Rank.KING;
```

Using `final` therefore helps communicate and enforce the intention that the object's state should not change.

However, Java does not have a single `immutable` keyword.

Immutability comes from the overall design of the class.

---

# 15. Why Immutability Helps Encapsulation

Suppose we have:

```java
List<Card> cards;
```

Even if the list cannot be modified, client code could potentially modify the objects inside it.

For example, with mutable cards:

```java
cards.get(0).setSuit(Suit.HEARTS);
```

The list itself was not changed.

But one of the objects stored inside the list was changed.

If `Card` is immutable, there is no operation such as:

```java
setSuit(...)
```

Therefore:

```text
Unmodifiable collection
    ↓
prevents adding/removing elements

Immutable elements
    ↓
prevents changing the elements themselves
```

Combining these gives stronger encapsulation.

---

# 16. Exposing Internal Data

Sometimes client code needs to inspect data stored inside an object.

Returning the internal list directly is dangerous:

```java
public List<Card> cards() {
    return aCards;
}
```

There are several safer strategies.

---

# 17. Strategy 1 — Extend the Interface

Instead of exposing the complete list:

```java
public int size() {
    return aCards.size();
}

public Card cardAt(int index) {
    return aCards.get(index);
}
```

Now client code can inspect cards without receiving the actual internal collection.

---

# 18. Strategy 2 — Return a Copy

Another possibility:

```java
public List<Card> cards() {
    return new ArrayList<>(aCards);
}
```

This creates a new list.

Conceptually:

```text
Deck list:
[A, B, C]

Client list:
[A, B, C]
```

There are two separate list objects.

Therefore:

```java
List<Card> result = deck.cards();
result.clear();
```

only clears the client's copy.

The `Deck`'s list remains unchanged.

---

# 19. Shallow Copies

This:

```java
new ArrayList<>(aCards)
```

creates a new list, but normally does not create new copies of every object inside it.

Therefore:

```text
Original List ------\
                     > Card A
Copied List --------/
```

Both lists may contain references to the same `Card` objects.

This is called a **shallow copy**.

If `Card` is immutable, sharing the cards is harmless.

If `Card` were mutable, client code might still modify them.

---

# 20. Strategy 3 — `Collections.unmodifiableList`

Another solution is:

```java
public List<Card> cards() {
    return Collections.unmodifiableList(aCards);
}
```

This creates an **unmodifiable view** of the original list.

The client can read it:

```java
cards.get(0);
cards.size();
```

but cannot modify the list using that reference:

```java
cards.add(...);
cards.remove(...);
cards.clear();
```

These modification attempts result in an exception.

Conceptually:

```text
Deck
  |
  v
[A, B, C]
  ^
  |
read-only view
  ^
  |
client
```

---

# 21. `unmodifiableList` vs `new ArrayList`

These solve similar problems in different ways.

## Copy

```java
return new ArrayList<>(aCards);
```

creates a separate collection.

Think:

```text
snapshot
```

If the original list changes later, the old copy does not automatically change.

---

## Unmodifiable View

```java
return Collections.unmodifiableList(aCards);
```

does not create an independent copy of the list.

Think:

```text
read-only window
```

If the original list changes internally, the view reflects those changes.

---

## Simple Rule

```text
new ArrayList<>(cards)
= independent snapshot

Collections.unmodifiableList(cards)
= read-only view of the current list
```

Which one to use depends on the behavior that the class's interface should provide.

---

# 22. Important Limitation of `unmodifiableList`

`Collections.unmodifiableList` prevents modification of the **list structure**.

It prevents:

```java
add()
remove()
clear()
```

But it does not automatically make the objects inside the list immutable.

For example, if `Card` were mutable:

```java
cards.get(0).setSuit(Suit.HEARTS);
```

could still modify that card.

That is why immutability of the contained objects can also be important.

---

# 23. Input Validation

Even with good encapsulation, invalid input may still enter through methods or constructors.

For example:

```java
new Card(null, Suit.CLUBS);
```

A constructor could explicitly reject this:

```java
public Card(Rank rank, Suit suit) {
    if (rank == null || suit == null) {
        throw new IllegalArgumentException();
    }

    aRank = rank;
    aSuit = suit;
}
```

Now invalid input produces a defined error.

This is **input validation**.

---

# 24. Validating Object State

Input does not only mean explicit parameters.

The object on which a method is called is also relevant.

Consider:

```java
public Card draw() {
    return aCards.removeLast();
}
```

What if the deck is empty?

A clearer design could explicitly check:

```java
public Card draw() {
    if (isEmpty()) {
        throw new IllegalStateException();
    }

    return aCards.removeLast();
}
```

`IllegalStateException` communicates that the operation cannot currently be performed because of the object's state.

---

# 25. Design by Contract

**Design by Contract** makes the responsibilities of a method and its caller explicit.

It uses:

- **preconditions**
- **postconditions**

## Preconditions

A precondition describes something that must already be true when the method starts.

Example:

```java
/**
 * @pre pRank != null && pSuit != null
 */
public Card(Rank pRank, Suit pSuit) {
}
```

This means:

> Whoever calls this constructor is responsible for providing non-null values.

---

# 26. Postconditions

A postcondition describes something that must be true after the method successfully finishes.

Conceptually:

```text
Precondition
    ↓
method executes
    ↓
Postcondition
```

The contract means:

> If the caller respects the precondition, the method promises to satisfy its postconditions.

---

# 27. `assert`

Java's `assert` statement expresses a condition that the programmer believes should always be true at that point.

Example:

```java
assert rank != null;
```

If:

```java
rank != null
```

is true, execution continues normally.

If it is false, Java raises:

```text
AssertionError
```

For example:

```java
public Card(Rank rank, Suit suit) {
    assert rank != null && suit != null;

    aRank = rank;
    aSuit = suit;
}
```

The meaning is:

> According to the design of this program, the caller should never pass `null`.

---

# 28. `assert` Is Not Short Input Validation

These two pieces of code may look similar:

```java
assert rank != null;
```

and:

```java
if (rank == null) {
    throw new IllegalArgumentException();
}
```

But they communicate different design decisions.

---

# 29. Input Validation Meaning

```java
if (rank == null) {
    throw new IllegalArgumentException();
}
```

means:

> Invalid input may occur, and this method is responsible for detecting and rejecting it.

The exception behavior is therefore part of the method's interface.

---

# 30. Assertion Meaning

```java
assert rank != null;
```

means:

> This value should already be valid if the rest of the program was written correctly.

If the assertion fails, it indicates a programming or design mistake.

Therefore:

```text
Input validation
= bad input may occur, so handle/reject it

Assertion
= this situation should never occur in correct code
```

---

# 31. Assertions Can Be Disabled

Another important difference is that Java assertions are normally disabled unless they are enabled when running the program.

For example:

```text
java -ea Program
```

The `-ea` option means:

```text
enable assertions
```

Because assertions can be disabled, they must not be used for checks that the program always needs for safety or correctness.

This is another reason why:

```java
assert value != null;
```

is not simply a shorter replacement for:

```java
if (value == null) {
    throw new IllegalArgumentException();
}
```

---

# 32. Contract Responsibility

Design by Contract also makes responsibility clearer.

If a **precondition** fails:

```text
caller/client code is responsible
```

If a **postcondition** fails:

```text
the called method's implementation is responsible
```

This can make debugging easier.

---

# 33. Main Ideas to Remember

## Encapsulation

```text
Protect an object's internal state.
```

---

## Information Hiding

```text
Reveal only what client code needs.
Hide implementation details.
```

---

## Interface

```text
What outside code is allowed to use.
```

Usually, at this point in the book, this mainly means the class's public methods.

---

## Implementation

```text
How the class actually performs its work internally.
```

---

## Constructor

```text
Runs when an object is created with new.
Initializes the object's state.
```

Example:

```java
Card card = new Card(Rank.ACE, Suit.HEARTS);
```

---

## Primitive Obsession

Avoid representing meaningful domain concepts using unrelated primitive/basic types when a dedicated abstraction would make the design clearer.

Instead of:

```java
int card = 13;
```

prefer something such as:

```java
Card card = new Card(Rank.ACE, Suit.HEARTS);
```

---

## Record

Useful for representing a fixed group of related values with less boilerplate.

```java
public record Card(Rank rank, Suit suit) {}
```

---

## Private Fields

Prefer:

```java
private
```

for internal fields so that the class controls its own state.

---

## Escaping References

Do not accidentally expose references to mutable internal objects.

Bad:

```java
return aCards;
```

---

## Returning a Copy

```java
return new ArrayList<>(aCards);
```

Think:

```text
independent snapshot
```

---

## Unmodifiable View

```java
return Collections.unmodifiableList(aCards);
```

Think:

```text
read-only window
```

---

## Immutability

An immutable object cannot change after construction.

A typical immutable design has:

```text
private fields
no setters
no escaping mutable internal references
state initialized during construction
```

Using `final` fields can further enforce the intention.

---

## Input Validation

```java
if (invalid) {
    throw new IllegalArgumentException();
}
```

means the method actively detects and rejects invalid input.

---

## Assertion

```java
assert condition;
```

means:

```text
This condition should already be true
if the program was written correctly.
```

It is mainly for detecting programming/design mistakes, not normal runtime input errors.

---

# Final Mental Model

The chapter can be summarized as:

```text
                 Class
                   |
        +----------+----------+
        |                     |
     Interface           Implementation
        |                     |
  public operations      private details
        |                     |
        +----------+----------+
                   |
             Encapsulation
                   |
       protect internal state
                   |
       +-----------+-----------+
       |                       |
   Immutability         Avoid reference leaks
       |                       |
       +-----------+-----------+
                   |
             safer objects
```

The central goal is not merely to make fields `private`.

The goal is to design classes so that:

> Other code can use an object correctly without needing to know or manipulate its internal representation.