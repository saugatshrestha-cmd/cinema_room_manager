# 🎭 Cinema Room Manager

## 📌 Project Overview

Cinema Room Manager is a Java console application that simulates a simple movie theatre booking system. Users can:

- ✔ View the seating arrangement
- ✔ Purchase tickets (with seat validation and pricing)
- ✔ Check statistics (occupancy, revenue, etc.)
- ✔ Handle input errors (out-of-bounds or already booked seats)

This project is part of the JetBrains Academy (Hyperskill) Java track, focusing on console I/O, loops, and conditionals.

---

## 🛠 Features

- ✅ **Show the seats** – Displays the theatre layout with available (S) and booked (B) seats.
- ✅ **Buy a ticket** – Users select a seat, and the program validates the input, prevents double booking, and calculates the ticket price.
- ✅ **Statistics** – Provides:
  - 🎟 Number of purchased tickets
  - 📊 Occupancy percentage (rounded to 2 decimal places)
  - 💰 Current income from sales
  - 💵 Total possible income (if all seats are sold)
- ✅ **Error Handling** – Prevents:
  - ❌ Selecting seats out of range
  - ❌ Booking already purchased seats
- ✅ **Interactive Menu** – Keeps running until the user exits.

---

## 📜 Usage Example

```
Enter the number of rows:
> 6
Enter the number of seats in each row:
> 6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
> 3
Enter a seat number in that row:
> 4
Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 3

Number of purchased tickets: 1
Percentage: 2.78%
Current income: $10
Total income: $360
```

##💡 Pricing Logic
-If the total number of seats ≤ 60, each ticket costs $10.
-Otherwise:
  -Front half of the rows → $10 per ticket
  -Back half of the rows → $8 per ticket
