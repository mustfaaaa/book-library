<h1>Book Lending Component System - Summary</h1>

  <h2>1. Delete Functionality Added</h2>
  <ul>
    <li><code>removeBook(String title)</code> was added to <strong>LibraryService</strong>.</li>
    <li><strong>LibraryComponent</strong> now implements book deletion logic.</li>
    <li><strong>MainApp</strong> allows users to delete books by title.</li>
  </ul>

  <h2>2. Swappable Storage Mechanism</h2>
  <ul>
    <li><strong>LibraryStorage</strong> was converted into an interface.</li>
    <li>Two implementations were created:
      <ul>
        <li><strong>InMemoryLibraryStorage</strong> (stores in memory)</li>
        <li><strong>FileLibraryStorage</strong> (stores in <code>books.txt</code>)</li>
      </ul>
    </li>
    <li>Storage can be swapped easily in <code>MainApp</code>.</li>
  </ul>

  <h2>3. Logging System Introduced</h2>
  <ul>
    <li><strong>Logger</strong> interface was created for pluggable logging.</li>
    <li><strong>ConsoleLogger</strong> was implemented to log messages to the console.</li>
    <li>All add/delete actions now produce log messages through this logger.</li>
  </ul>

  <h2>4. Design Principles Applied</h2>
  <ul>
    <li><strong>Dependency Inversion</strong>: Interfaces used for storage and logging.</li>
    <li><strong>Open/Closed Principle</strong>: Easily extendable without modifying core logic.</li>
    <li><strong>Low Coupling</strong>: Logger and Storage are injected, not hardcoded.</li>
  </ul>
