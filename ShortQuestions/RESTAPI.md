### GET
https://api-m.sandbox.paypal.com/v2/invoicing/invoices?page_size=10
https://api-m.sandbox.paypal.com/v2/invoicing/invoices/:invoice_id
https://api-m.sandbox.paypal.com/v1/notifications/webhooks-event-types
https://api-m.sandbox.paypal.com/v2/checkout/orders/:order_id
https://api-m.sandbox.paypal.com/v2/payments/authorizations/:authorization_id
### POST
https://api-m.sandbox.paypal.com/v1/oauth2/token
```
{
    "scope": "https://uri.paypal.com/services/payments/partnerfee https://uri.paypal.com/services/vault/payment-tokens/read https://uri.paypal.com/services/disputes/read-buyer https://uri.paypal.com/services/payments/realtimepayment https://uri.paypal.com/services/customer/partner-referrals https://uri.paypal.com/services/customer/onboarding/user https://uri.paypal.com/services/payments/referenced-payouts/read https://uri.paypal.com/services/disputes/update-buyer https://uri.paypal.com/services/vault/carrier-accounts/update https://uri.paypal.com/services/wallet/bank-accounts/read https://uri.paypal.com/services/reporting/search/read https://uri.paypal.com/services/wallet/balance-accounts/read https://uri.paypal.com/services/wallet/bank-accounts/internal-read https://uri.paypal.com/services/customer/partner https://uri.paypal.com/services/vault/payment-tokens/readwrite https://uri.paypal.com/services/customer/merchant-integrations/read https://uri.paypal.com/services/customer/verification-tokens/readwrite https://uri.paypal.com/v1/billing-agreements/agreementlist https://uri.paypal.com/services/vault/carrier-accounts/view https://uri.paypal.com/services/applications/webhooks https://uri.paypal.com/services/vault/restricted-elements/read https://uri.paypal.com/services/disputes/update-seller openid https://uri.paypal.com/services/billing-agreements/agreements/cancel https://uri.paypal.com/services/identity/grantdelegation https://uri.paypal.com/services/payments/referenced-payouts/readwrite https://uri.paypal.com/services/customer/onboarding/applications https://uri.paypal.com/services/customer/onboarding/account https://uri.paypal.com/payments/payouts https://uri.paypal.com/services/disputes/update-partner https://uri.paypal.com/services/customer/partner-referrals/readwrite https://uri.paypal.com/services/invoicing https://uri.paypal.com/services/disputes/read-partner https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/payments/.* https://uri.paypal.com/services/payments/referenced-payouts-items/readwrite https://uri.paypal.com/services/wallet/bank-accounts/internal-update https://uri.paypal.com/services/payments/channelpartner https://api.paypal.com/v1/payments/refund https://uri.paypal.com/services/payments/reversepayment Braintree:Vault https://uri.paypal.com/services/disputes/read-seller https://uri.paypal.com/services/payments/referenced-payouts-items/read https://uri.paypal.com/services/payments/refund https://uri.paypal.com/services/risk/raas/transaction-context https://uri.paypal.com/services/disputes/create https://uri.paypal.com/services/customer/consumer-referrals/create https://uri.paypal.com/services/partners/merchant-accounts/readwrite https://uri.paypal.com/services/customer/supporting-documents/readwrite https://uri.paypal.com/services/customer/onboarding/sessions https://api.paypal.com/v1/vault/credit-card/.* https://uri.paypal.com/services/shipping/trackers/readwrite https://uri.paypal.com/services/subscriptions https://uri.paypal.com/services/wallet/bank-accounts/partner-update https://uri.paypal.com/services/wallet/bank-accounts/update",
    "access_token": "A21AAJ79msQguZiMsdhBcXyE81VohugKCb5-HIynCIjv3vBSQuZN0Agcq1VPtdeXOcgcfvj8iWVz3OJgRC4ojVBiwGdVD0Rzg",
    "token_type": "Bearer",
    "app_id": "APP-80W284485P519543T",
    "expires_in": 32345,
    "nonce": "2024-01-08T02:17:25Z9WUqeN8TvvsYwHeKiZxNxvaUU5vgjsV_TIYqXXyGs38"
}
```

https://api-m.sandbox.paypal.com/v1/oauth2/token/terminate
```
{
    "error": "invalid_token",
    "error_description": "Token signature verification failed"
}
```
https://api-m.sandbox.paypal.com/v1/identity/generate-token
```
{
    "client_token": "eyJicmFpbnRyZWUiOnsiYXV0aG9yaXphdGlvbkZpbmdlcnByaW50IjoiOTllYWY1NjBjN2RmOWNlNWQ0ZjJkOWIzOTQxMjhhZGY2NTg2ZWUxNDc3NzllOTg5MWUyMWQ3YjhlYzA0YTg1YnxtZXJjaGFudF9pZD1yd3dua3FnMnhnNTZobTJuJnB1YmxpY19rZXk9NjNrdm4zN3Z0MjlxYjRkZiZjcmVhdGVkX2F0PTIwMjQtMDEtMDhUMDQ6MzU6NTQuNTI3WiIsInZlcnNpb24iOiIzLXBheXBhbCJ9LCJwYXlwYWwiOnsiaWRUb2tlbiI6bnVsbCwiYWNjZXNzVG9rZW4iOiJBMjFBQUliUDA0MWpkVTBzSHIyNERmMDJJVU1aTnBaMndiODhFcnEwVUg1N0drYzg3a2FvOVRWZFJOMTc1LTNPMmc1cEl3NEtVRlB3cE1URlJBNGpZeFM2UTlib21NT2Z3In19",
    "expires_in": 3600
}
```
https://api-m.sandbox.paypal.com/v2/checkout/orders
```
{
    "id": "55J161711W812874T",
    "intent": "CAPTURE",
    "status": "CREATED",
    "purchase_units": [
        {
            "reference_id": "default",
            "amount": {
                "currency_code": "USD",
                "value": "100.00"
            },
            "payee": {
                "email_address": "john_merchant@example.com",
                "merchant_id": "C7CYMKZDG8D6E"
            }
        }
    ],
    "create_time": "2024-01-08T04:36:45Z",
    "links": [
        {
            "href": "https://api.sandbox.paypal.com/v2/checkout/orders/55J161711W812874T",
            "rel": "self",
            "method": "GET"
        },
        {
            "href": "https://www.sandbox.paypal.com/checkoutnow?token=55J161711W812874T",
            "rel": "approve",
            "method": "GET"
        },
        {
            "href": "https://api.sandbox.paypal.com/v2/checkout/orders/55J161711W812874T",
            "rel": "update",
            "method": "PATCH"
        },
        {
            "href": "https://api.sandbox.paypal.com/v2/checkout/orders/55J161711W812874T/capture",
            "rel": "capture",
            "method": "POST"
        }
    ]
}
```
https://api-m.sandbox.paypal.com/v2/checkout/orders/:order_id/authorize
```
{
    "name": "UNPROCESSABLE_ENTITY",
    "details": [
        {
            "issue": "ORDER_NOT_APPROVED",
            "description": "Payer has not yet approved the Order for payment. Please redirect the payer to the 'rel':'approve' url returned as part of the HATEOAS links within the Create Order call or provide a valid payment_source in the request."
        }
    ],
    "message": "The requested action could not be performed, semantically incorrect, or failed business validation.",
    "debug_id": "c7b0590b4c5cd",
    "links": [
        {
            "href": "https://developer.paypal.com/docs/api/orders/v2/#error-ORDER_NOT_APPROVED",
            "rel": "information_link",
            "method": "GET"
        }
    ]
}
```
### PUT
{{base_url}}/v2/invoicing/invoices/:invoice_id?send_to_recipient=true&send_to_invoicer=true
```
{
    "id": "{{invoice_id}}",
    "status": "DRAFT",
    "detail": {
        "invoice_number": "{{$timestamp}}",
        "reference": "deal-reference-update",
        "invoice_date": "2018-11-12",
        "currency_code": "USD",
        "note": "Thank you for your business.",
        "term": "No refunds after 30 days.",
        "memo": "This is a long contract",
        "payment_term": {
            "term_type": "NET_10",
            "due_date": "2018-11-22"
        }
    },
    "invoicer": {
        "name": {
            "given_name": "David",
            "surname": "Larusso"
        },
        "address": {
            "address_line_1": "1234 First Street",
            "address_line_2": "337673 Hillside Court",
            "admin_area_2": "Anytown",
            "admin_area_1": "CA",
            "postal_code": "98765",
            "country_code": "US"
        },
        "phones": [
            {
                "country_code": "001",
                "national_number": "4085551234",
                "phone_type": "MOBILE"
            }
        ],
        "website": "www.test.com",
        "tax_id": "ABcNkWSfb5ICTt73nD3QON1fnnpgNKBy-Jb5SeuGj185MNNw6g",
        "logo_url": "https://example.com/logo.PNG",
        "additional_notes": "2-4"
    },
    "primary_recipients": [
        {
            "billing_info": {
                "name": {
                    "given_name": "Stephanie",
                    "surname": "Meyers"
                },
                "address": {
                    "address_line_1": "1234 Main Street",
                    "admin_area_2": "Anytown",
                    "admin_area_1": "CA",
                    "postal_code": "98765",
                    "country_code": "US"
                },
                "email_address": "foobuyer@gmail.com",
                "phones": [
                    {
                        "country_code": "001",
                        "national_number": "4884551234",
                        "phone_type": "HOME"
                    }
                ],
                "additional_info_value": "add-info"
            },
            "shipping_info": {
                "name": {
                    "given_name": "Stephanie",
                    "surname": "Meyers"
                },
                "address": {
                    "address_line_1": "1234 Main Street",
                    "admin_area_2": "Anytown",
                    "admin_area_1": "CA",
                    "postal_code": "98765",
                    "country_code": "US"
                }
            }
        }
    ],
    "items": [
        {
            "name": "Yoga Mat",
            "description": "Elastic mat to practice yoga.",
            "quantity": "1",
            "unit_amount": {
                "currency_code": "USD",
                "value": "50.00"
            },
            "tax": {
                "name": "Sales Tax",
                "percent": "7.25",
                "amount": {
                    "currency_code": "USD",
                    "value": "3.27"
                }
            },
            "discount": {
                "percent": "5",
                "amount": {
                    "currency_code": "USD",
                    "value": "2.5"
                }
            },
            "unit_of_measure": "QUANTITY"
        },
        {
            "name": "Yoga t-shirt",
            "quantity": "1",
            "unit_amount": {
                "currency_code": "USD",
                "value": "10.00"
            },
            "tax": {
                "name": "Sales Tax",
                "percent": "7.25",
                "amount": {
                    "currency_code": "USD",
                    "value": "0.34"
                }
            },
            "discount": {
                "amount": {
                    "currency_code": "USD",
                    "value": "5.00"
                }
            },
            "unit_of_measure": "QUANTITY"
        }
    ],
    "configuration": {
        "partial_payment": {
            "allow_partial_payment": true,
            "minimum_amount_due": {
                "currency_code": "USD",
                "value": "20.00"
            }
        },
        "allow_tip": true,
        "tax_calculated_after_discount": true,
        "tax_inclusive": false
    },
    "amount": {
        "currency_code": "USD",
        "value": "74.21",
        "breakdown": {
            "item_total": {
                "currency_code": "USD",
                "value": "60.00"
            },
            "custom": {
                "label": "Packing Charges",
                "amount": {
                    "currency_code": "USD",
                    "value": "10.00"
                }
            },
            "shipping": {
                "amount": {
                    "currency_code": "USD",
                    "value": "10.00"
                },
                "tax": {
                    "name": "Sales Tax",
                    "percent": "7.25",
                    "amount": {
                        "currency_code": "USD",
                        "value": "0.73"
                    }
                }
            },
            "discount": {
                "item_discount": {
                    "currency_code": "USD",
                    "value": "-7.50"
                },
                "invoice_discount": {
                    "percent": "5",
                    "amount": {
                        "currency_code": "USD",
                        "value": "-2.63"
                    }
                }
            },
            "tax_total": {
                "currency_code": "USD",
                "value": "4.34"
            }
        }
    }
}
```
{{base_url}}/v2/invoicing/templates/:template_id
```
{
    "id": "TEMP-1L131815AG126341C",
    "name": "Meta Rebranded",
    "default_template": true,
    "template_info": {
        "detail": {
            "reference": "deal-reference-value",
            "currency_code": "USD",
            "note": "Thank you for your business.",
            "terms_and_conditions": "No refunds after 30 days.",
            "memo": "This is a long contract",
            "attachments": [
                {
                    "id": "Screen Shot 2018-11-23 at 16.45.01.png",
                    "reference_url": "https://www.sandbox.paypal.com/invoice/payerView/attachments/RkG9ggQbd4Mwm1tYdcF6uuixfFTFq32bBdbE1VbtQLdKSoS2ZOYpfjw9gPp7eTrZmVaFaDWzixHXm-OXWHbmigHigHzURDxJs8IIKqcqP8jawnBEZcraEAPVMULxf5iTyOSpAUc2ugW0PWdwDbM6mg-guFAUyj3Z98H7htWNjQY95jb9heOlcSXUe.sbDUR9smAszzzJoA1NXT6rEEegwQ&version=1&sig=JNODB0xEayW8txMQm6ZsIwDnd4eh3hd6ijiRLi4ipHE"
                }
            ],
            "category_code": "SHIPPABLE",
            "payment_term": {
                "term_type": "NET_10"
            },
            "metadata": {
                "create_time": "2022-02-07T23:32:37Z"
            }
        },
        "invoicer": {
            "name": {
                "given_name": "David",
                "surname": "Larusso",
                "full_name": "David Larusso"
            },
            "address": {
                "address_line_1": "1234 First Street",
                "address_line_2": "337673 Hillside Court",
                "admin_area_2": "Anytown",
                "admin_area_1": "CA",
                "postal_code": "98765",
                "country_code": "US"
            },
            "email_address": "merchant@example.com",
            "phones": [
                {
                    "country_code": "001",
                    "national_number": "4085551234",
                    "phone_type": "MOBILE"
                }
            ],
            "website": "www.test.com",
            "tax_id": "ABcNkWSfb5ICTt73nD3QON1fnnpgNKBy-Jb5SeuGj185MNNw6g",
            "additional_notes": "2-4",
            "logo_url": "https://example.com/logo.PNG"
        },
        "primary_recipients": [
            {
                "billing_info": {
                    "name": {
                        "given_name": "Stephanie",
                        "surname": "Meyers",
                        "full_name": "Stephanie Meyers"
                    },
                    "address": {
                        "address_line_1": "1234 Main Street",
                        "admin_area_2": "Anytown",
                        "admin_area_1": "CA",
                        "postal_code": "98765",
                        "country_code": "US"
                    },
                    "email_address": "bill-me@example.com",
                    "phones": [
                        {
                            "country_code": "001",
                            "national_number": "4884551234",
                            "phone_type": "MOBILE"
                        }
                    ],
                    "additional_info": "add-info"
                },
                "shipping_info": {
                    "name": {
                        "given_name": "Stephanie",
                        "surname": "Meyers",
                        "full_name": "Stephanie Meyers"
                    },
                    "address": {
                        "address_line_1": "1234 Main Street",
                        "admin_area_2": "Anytown",
                        "admin_area_1": "CA",
                        "postal_code": "98765",
                        "country_code": "US"
                    }
                }
            }
        ],
        "additional_recipients": [
            "inform-me@example.com"
        ],
        "items": [
            {
                "id": "ITEM-46P63667WB0225010",
                "name": "Yoga Mat",
                "description": "new watch",
                "quantity": "1",
                "unit_amount": {
                    "currency_code": "USD",
                    "value": "50.00"
                },
                "discount": {
                    "percent": "5"
                },
                "unit_of_measure": "QUANTITY"
            },
            {
                "id": "ITEM-5WW56772EU971432W",
                "name": "Yoga T Shirt",
                "quantity": "1",
                "unit_amount": {
                    "currency_code": "USD",
                    "value": "10.00"
                },
                "discount": {
                    "amount": {
                        "currency_code": "USD",
                        "value": "-5.00"
                    }
                },
                "unit_of_measure": "QUANTITY"
            }
        ],
        "configuration": {
            "tax_calculated_after_discount": true,
            "tax_inclusive": false,
            "allow_tip": true,
            "partial_payment": {
                "allow_partial_payment": true,
                "minimum_amount_due": {
                    "currency_code": "USD",
                    "value": "20.00"
                }
            }
        },
        "amount": {
            "breakdown": {
                "discount": {
                    "invoice_discount": {
                        "percent": "5"
                    }
                },
                "shipping": {
                    "amount": {
                        "currency_code": "USD",
                        "value": "10.00"
                    }
                },
                "custom": {
                    "label": "Packing Charges",
                    "amount": {
                        "currency_code": "USD",
                        "value": "10.00"
                    }
                }
            }
        }
    },
    "settings": {
        "template_item_settings": [
            {
                "field_name": "items.date",
                "display_preference": {
                    "hidden": true
                }
            },
            {
                "field_name": "items.discount",
                "display_preference": {
                    "hidden": false
                }
            },
            {
                "field_name": "items.tax",
                "display_preference": {
                    "hidden": false
                }
            },
            {
                "field_name": "items.description",
                "display_preference": {
                    "hidden": false
                }
            },
            {
                "field_name": "items.quantity",
                "display_preference": {
                    "hidden": true
                }
            }
        ],
        "template_subtotal_settings": [
            {
                "field_name": "custom",
                "display_preference": {
                    "hidden": false
                }
            },
            {
                "field_name": "discount",
                "display_preference": {
                    "hidden": false
                }
            },
            {
                "field_name": "shipping",
                "display_preference": {
                    "hidden": false
                }
            }
        ]
    },
    "unit_of_measure": "QUANTITY",
    "standard_template": false,
    "links": [
        {
            "href": "https://api.sandbox.paypal.com/v2/invoicing/templates/TEMP-1L131815AG126341C",
            "rel": "self",
            "method": "GET"
        },
        {
            "href": "https://api.sandbox.paypal.com/v2/invoicing/templates/TEMP-1L131815AG126341C",
            "rel": "delete",
            "method": "DELETE"
        },
        {
            "href": "https://api.sandbox.paypal.com/v2/invoicing/templates/TEMP-1L131815AG126341C",
            "rel": "replace",
            "method": "PUT"
        }
    ]
}
```
{{base_url}}/v1/shipping/trackers/:tracking_id
```
{
    "transaction_id": "{{capture_id}}",
    "tracking_number": "{{tracking_number}}",
    "status": "SHIPPED",
    "carrier": "OTHER",
    "carrier_name_other": "{{$randomCompanyName}}"
}
```
### DELETE
{{base_url}}/v2/invoicing/invoices/:invoice_id/payments/:transaction_id
{{base_url}}/v2/invoicing/invoices/:invoice_id