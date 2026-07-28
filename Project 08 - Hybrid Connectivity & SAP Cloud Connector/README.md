# Project 08: Secure Hybrid Cloud Tunneling via SAP Cloud Connector

## 🎯 Project Overview
This project establishes the structural configuration blueprint and mock local architecture required to securely bridge on-premise localized databases with the cloud-hosted **SAP BTP Subaccount** without opening holes in the corporate firewall.

## 🔒 Security Configuration Architecture
[ SAP BTP Subaccount (Cloud Foundry) ]
│
▼ (Secure TLS Encryption Tunnel)
[ SAP Cloud Connector ]
│
▼ (Virtual Mapping Link: virtual-erp-backend.internal:8080)
[ Local Enterprise Mock Database / Service Layer (Port 8081) ]

## ⚙️ Implemented Controls
* **Firewall Preservation:** Zero inbound ports opened on the local/corporate side; the Cloud Connector establishes an outbound-initiated TLS tunnel to BTP.
* **Virtual Obfuscation:** The cloud environment only sees a virtual host name (`virtual-erp-backend.internal`), hiding the actual internal network topology.
* **Granular Whitelisting:** Only explicit, pre-defined HTTP path prefixes are allowed through the access control lists.
