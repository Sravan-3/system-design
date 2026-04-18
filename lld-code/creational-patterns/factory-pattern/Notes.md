# Factory Method is used when the base class does not know which concrete object it should create, so it delegates object creation to its subclasses and works only with abstractions at runtime.


1️⃣ Core idea (1-line intuition)

Factory Method = “Let subclasses decide which object gets created, while the base class decides when it’s used.”

Creation varies → usage stays stable.

2️⃣ Applicability #1

“Use Factory Method when you don’t know beforehand the exact types and dependencies…”

❌ Without Factory Method (tight coupling)
class Application {
    void render() {
        WindowsButton btn = new WindowsButton(); // hard-coded
        btn.render();
    }
}

Problems:

App is married to WindowsButton

Tomorrow: Mac / Linux → rewrite code

Violates Open–Closed Principle

✅ With Factory Method
Product interface
interface Button {
    void render();
}

Creator (FACTORY)
abstract class Dialog {

    public void render() {
        Button btn = createButton(); // unknown type
        btn.render();
    }

    protected abstract Button createButton();
}

Concrete creators
class WindowsDialog extends Dialog {
    protected Button createButton() {
        return new WindowsButton();
    }
}

class HtmlDialog extends Dialog {
    protected Button createButton() {
        return new HtmlButton();
    }
}

Client
Dialog dialog = new WindowsDialog();
dialog.render();


👉 The code that uses the product (render) does NOT know the concrete type.

That directly explains:

“Factory Method separates product construction code from the code that actually uses the product.”

3️⃣ Applicability #2

“When you want to provide users of your library or framework a way to extend internal components”

This is framework design.

Framework author’s code (you)
abstract class UIFramework {

    public void drawUI() {
        Button b = createButton();
        b.render();
    }

    protected Button createButton() {
        return new SquareButton(); // default behavior
    }
}

Framework user’s code (library consumer)
class UIWithRoundButtons extends UIFramework {

    @Override
    protected Button createButton() {
        return new RoundButton(); // custom behavior
    }
}


Usage:

UIFramework ui = new UIWithRoundButtons();
ui.drawUI();


💡 Key insight
The framework never asks:

“Are you using RoundButton?”

It simply calls createButton().

That explains this line perfectly:

“But how would the framework recognize that your subclass should be used instead of a standard component?”

Answer: polymorphism + factory method.

4️⃣ Applicability #3

“Save system resources by reusing existing objects…”

Now let’s do resource pooling, where constructors are insufficient.

❌ Why constructor fails
class DBConnection {
    DBConnection() {
        // always creates a NEW connection
    }
}


Constructor:

❌ Cannot return existing object

❌ No pooling logic

✅ Factory Method with reuse
Product
class DBConnection {
    void connect() {}
}

Creator (Factory)
abstract class ConnectionFactory {

    protected abstract DBConnection createConnection();

    public DBConnection getConnection() {
        // could reuse from pool here
        return createConnection();
    }
}

Concrete factory with pooling
class PooledConnectionFactory extends ConnectionFactory {

    private Queue<DBConnection> pool = new LinkedList<>();

    @Override
    protected DBConnection createConnection() {
        if (!pool.isEmpty()) {
            return pool.poll(); // reuse
        }
        return new DBConnection(); // create new
    }

    public void release(DBConnection conn) {
        pool.offer(conn);
    }
}


👉 This explains:

“You need a regular method capable of creating new objects as well as reusing existing ones.”

That regular method is the factory method.

5️⃣ “How to Implement” — mapped directly

Your text → concrete meaning:

Step from text	What it means in code
Common interface	Button, DBConnection
Empty factory method	createButton(), createConnection()
Replace constructors	new Button() → createButton()
Temporary switch	if(type == X) inside factory
Subclasses	WindowsDialog, HtmlDialog
Make base abstract	abstract createButton()
6️⃣ Pros & Cons — grounded
✅ Pros (why interviewers love it)

No tight coupling (Dialog doesn’t know concrete buttons)

Creation logic isolated

Easy extension without touching old code

❌ Cons (realistic trade-off)

Class explosion
(WindowsDialog, MacDialog, LinuxDialog, etc.)

Overkill for small apps

7️⃣ Relationship with other patterns (intuition)

Factory Method → simplest

Abstract Factory → multiple related products

Builder → step-by-step construction

Prototype → clone instead of new

Template Method → algorithm skeleton, factory is one step

💡 Important line from your text:

“Factory Method is a specialization of Template Method”

Your render() method is a template:

public void render() {
    Button b = createButton(); // hook
    b.render();
}

8️⃣ Interview-ready summary (memorize this 🔥)

Factory Method defines an interface for creating an object but lets subclasses decide which class to instantiate. It decouples object creation from usage and enables extension via inheritance without modifying existing code.