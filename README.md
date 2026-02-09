# ☕ Cafe Order System

> Modern, commission-free cafe management system with WhatsApp ordering integration. Built for small businesses who want full control over their orders.

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)

## 🌟 Why Choose Cafe Order System?

- **💰 Zero Commission** - No Zomato/Swiggy fees (save 20-30% per order)
- **📱 WhatsApp Integration** - Direct orders via WhatsApp
- **🚀 Easy Setup** - Deploy in minutes, not days
- **💼 Full Control** - Your data, your customers, your business
- **🎨 Professional Design** - Modern, mobile-responsive interface
- **📊 Admin Dashboard** - Track orders, manage menu, view analytics

---

## 📸 Screenshots

### Customer Interface
![Customer Menu](screenshots/menu-page.png)
*Clean, mobile-friendly menu with cart system*

### Admin Dashboard
![Admin Panel](screenshots/admin-dashboard.png)
*Powerful admin panel for order management*

### WhatsApp Integration
![WhatsApp Order](screenshots/whatsapp-order.png)
*Seamless WhatsApp ordering experience*

---

## 🚀 Features

### For Customers
- ✅ Browse menu by categories (Coffee, Snacks, Meals)
- ✅ Add/remove items from cart
- ✅ Adjust quantities easily
- ✅ Place orders via WhatsApp
- ✅ 100% mobile responsive
- ✅ Fast loading times

### For Business Owners
- ✅ Complete menu management (Add/Edit/Delete items)
- ✅ Real-time order tracking
- ✅ Category-based organization
- ✅ Image upload for menu items
- ✅ Price management
- ✅ Customer order history
- ✅ Secure admin authentication

### Technical Features
- ✅ Spring Boot 3.2+ backend
- ✅ Thymeleaf templating engine
- ✅ MySQL database
- ✅ RESTful API design
- ✅ Secure session management
- ✅ Responsive Bootstrap 5 UI

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java 17+** | Backend programming language |
| **Spring Boot 3.2** | Application framework |
| **Thymeleaf** | Server-side templating |
| **MySQL 8.0** | Database |
| **Bootstrap 5** | Frontend framework |
| **WhatsApp Business API** | Order integration |

---



## 📁 Project Structure

```
cafe-order-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/codetrust/cafe/
│   │   │       ├── controller/     # REST controllers
│   │   │       ├── model/          # Entity classes
│   │   │       ├── repository/     # Data access layer
│   │   │       ├── service/        # Business logic
│   │   │       └── CafeApplication.java
│   │   └── resources/
│   │       ├── static/             # CSS, JS, images
│   │       ├── templates/          # Thymeleaf templates
│   │       └── application.properties
│   └── test/                       # Unit tests
├── screenshots/                    # App screenshots
├── README.md
├── pom.xml                        # Maven dependencies
└── .gitignore
```

---



## 📚 API Documentation


### Admin Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/admin/login` | Admin login page |
| POST | `/admin/login` | Authenticate admin |
| GET | `/admin/dashboard` | Admin dashboard |
| GET | `/admin/menu` | Menu management |
| POST | `/admin/menu/add` | Add menu item |
| PUT | `/admin/menu/edit/{id}` | Edit menu item |
| DELETE | `/admin/menu/delete/{id}` | Delete menu item |

---


## 🔐 Security Features

- ✅ Admin authentication with session management
- ✅ Password encryption (bcrypt)
- ✅ SQL injection prevention (JPA)
- ✅ CSRF protection enabled
- ✅ Input validation
- ✅ Secure file upload handling

---

## 📈 Roadmap

### Version 2.0 (Planned)
- [ ] Payment gateway integration (Razorpay/Stripe)
- [ ] Email notifications
- [ ] SMS integration
- [ ] Advanced analytics dashboard
- [ ] Multi-branch support
- [ ] Staff management
- [ ] Inventory tracking
- [ ] Customer loyalty program
- [ ] Mobile app (React Native)
- [ ] Multi-language support

---

## 💡 Use Cases

Perfect for:
- ☕ Small cafes
- 🍕 Cloud kitchens
- 🍰 Bakeries
- 🥪 Food trucks
- 🍜 Small restaurants
- 🧃 Juice bars
- 🍦 Ice cream parlors

---

## 📞 Support

- **Documentation:** [Wiki](https://github.com/YOUR-USERNAME/cafe-order-system/wiki)
- **Issues:** [GitHub Issues](https://github.com/YOUR-USERNAME/cafe-order-system/issues)
- **Email:** codetrust.help@gmail.com
- **Instagram:** [@codetrust_it_services](https://instagram.com/codetrust_it_services)

---



## 🙏 Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot) - Amazing framework
- [Bootstrap](https://getbootstrap.com/) - Responsive design
- [Thymeleaf](https://www.thymeleaf.org/) - Templating engine


---

## ⭐ Star History

If this project helped you, please consider giving it a ⭐!

[![Star History Chart](https://api.star-history.com/svg?repos=codetrustitservices/cafe-order-system&type=Date)](https://star-history.com/#YOUR-USERNAME/cafe-order-system&Date)

---

## 📱 Connect With Us

- **Website:** [CodeTrust IT Services](https://github.com/codetrustitservices)
- **Instagram:** [@codetrust_it_services](https://instagram.com/codetrust_it_services)
- **LinkedIn:** [CodeTrust IT Services](https://linkedin.com/company/codetrust-it-services)
- **YouTube:** [CodeTrust IT Services](https://youtube.com/@codetrustitservices)

---

<div align="center">

**Made with ❤️ by CodeTrust IT Services**

⭐ Star this repo if you find it useful! ⭐

[Report Bug](https://github.com/codetrustitservices/cafe-order-system/issues) · [Request Feature](https://github.com/codetrustitservices/cafe-order-system/issues) · [Documentation](https://github.com/YOUR-USERNAME/cafe-order-system/wiki)

</div>
