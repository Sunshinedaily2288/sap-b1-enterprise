# SAP Business One Enterprise Integration Architecture

A 10-project implementation repository focused on SAP B1 Service Layer, B1if middleware, and SAP BTP integration.

## 🗺 Project Roadmap
* **Phase 1 (Service Layer/Webhooks):** Projects 1-4 (Project 3 Complete).
* **Phase 2 (B1if Middleware):** Projects 5-7 (Project 6 Complete).
* **Phase 3 (BTP Hybrid Cloud):** Projects 8-10.

## 🛠 Project Highlight: Project 03 (Service Layer Scripting)
Implemented `custom_bp_extension.js` for server-side validation and automated B2B data compliance within the SAP B1 Service Layer engine.

## 🛠 Project Highlight: Project 06 (BTP Message Mapping)
Deployed a Groovy-based, high-performance, zero-dependency data pipeline in SAP BTP to optimize warehouse order processing.
* **Process:** `[ Incoming Payload ] ➡️ [ Groovy Data Engine ] ➡️ [ Receiver ]`
* **Optimization:** Replaced graphical mapping with native Groovy `JsonSlurper` and `JsonOutput` to reduce latency and memory usage.
* **Key Mappings:** Direct JSON mapping of `warehouse_customer_id`, `expected_delivery_date`, `product_sku`, and `ordered_units`.

## ⚙️ Environment Configuration & Tools
* **Platform:** Postman API & Mockoon Developer Proxy.
* **API/Middleware:** SAP B1 Service Layer OData v4 / SAP BTP Cloud Integration.
* **Session Management:** `B1SESSION` + `ROUTEID`.
