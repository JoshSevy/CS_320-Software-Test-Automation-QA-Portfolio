# CS 320 - Software Testing and Automation

## Overview

This repository showcases my work from CS 320, focusing on software testing, automation, and quality assurance. It
includes the Contact Service from Project One and a Summary and Reflections report from Project Two.

These artifacts demonstrate my ability to design and implement unit tests, validate functionality based on requirements,
and apply testing strategies to improve software quality.

---

## Artifacts

### Project One: Contact Service

- Contact.java
- ContactService.java
- ContactTest.java
- ContactServiceTest.java

This project focuses on building a service layer and validating it through unit testing. It highlights test-driven
thinking, validation logic, and handling both expected and unexpected input.

### Project Two: Summary and Reflections Report

This report outlines my testing approach, experience with JUnit, and reflections on testing strategies, mindset, and
software quality.

[View PDF](CS_320_Project_Two.pdf) | [Download DOCX](CS_320_Project_Two.docx)

---

## Course Reflection

### How can I ensure that my code, program, or software is functional and secure?

To make sure my code works, I match my tests to the requirements and check both what should happen and what could go
wrong. I write unit tests for each requirement to confirm the system acts as expected.
This helps me see that everything works as it should in normal situations.

I also test corner cases as well as incorrect input, such as null values, duplicate IDs, or even incorrect operations,
to ensure my program is secure. Doing this helps me avoid introducing defects into later stages of my project
development cycle. From personal experience, I have found testing valid and invalid use cases essential to security.

---

### How do I interpret user needs and incorporate them into a program?

When I look at user needs, I turn their requirements into clear, testable steps. I don’t just think about how a feature
should work, but also how to check that it works. This way, I make sure what I build matches what users expect.

For instance, if users require field validation, a unique ID, and/or protection against erroneous data, the requirement
would be translated into validation logic or tests that ensure the user expectations are met by the system's actual
behavior.

---

### How do I approach designing software?

When I design software, I break it into smaller parts that I can build and test on their own. This makes it easier to
check if everything works and to keep the code organized over time.

Testing is a big part of how I design. I plan for both what should happen and what could go wrong from the start, which
shapes how I write my code. This helps me create cleaner, easier-to-maintain solutions and lowers the chance of problems
as the system gets bigger.

In practice, I focus on clear logic, strong checks, and writing tests as I go to make sure everything is high quality
from the beginning.

---

## Key Takeaways

- Writing tests aligned to requirements improves reliability and reduces defects
- Negative testing and edge case validation are critical for building robust systems
- Breaking systems into smaller components makes testing and maintenance easier
- Consistent testing practices help prevent technical debt over time

---

## Code Coverage

This project achieves **100% code coverage** across all classes, demonstrating thorough testing practices:

### Overall Metrics
| Metric | Coverage |
|--------|----------|
| **Instructions** | 100% (536/536) |
| **Branches** | 100% (78/78) |
| **Lines** | 100% (147/147) |
| **Methods** | 100% (44/44) |

### Per-Class Coverage
| Class | Instructions | Branches | Lines | Methods |
|-------|--------------|----------|-------|---------|
| **Appointment** | 100% (56) | 100% (12) | 100% (14) | 100% (4) |
| **Task** | 100% (84) | 100% (20) | 100% (22) | 100% (6) |
| **Contact** | 100% (136) | 100% (20) | 100% (44) | 100% (15) |
| **AppointmentService** | 100% (56) | 100% (6) | 100% (13) | 100% (4) |
| **TaskService** | 100% (90) | 100% (10) | 100% (23) | 100% (6) |
| **ContactService** | 100% (114) | 100% (10) | 100% (31) | 100% (9) |

---

## Tools & Technologies

- Java
- JUnit
- Maven
- JaCoCo
- GitHub

---

## Closing Thoughts

This project reinforced the importance of writing tests alongside development and thinking beyond just the "happy path."
It also strengthened my ability to connect requirements, implementation, and validation into a cohesive workflow.

---

## Author

Joshua Sevy