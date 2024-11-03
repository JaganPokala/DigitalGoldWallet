//package com.amisa.sprintevolution.digitalgoldwallet;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import java.net.http.HttpHeaders;
//import org.json.JSONException;
//import org.junit.jupiter.api.Test;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class DigiWalletUsersTest {
//	private	String usersbyid1 = "/api/v1/users/10"; 
//	String expectedusersbyid1 = 
//			"""
//{
//    "user_id": 10,
//    "email": "jay.patel@example.in",
//    "name": "Jay Patel",
//    "balance": 5800.0,
//    "created_at": "2024-03-18T12:41:49",
//    "addresses": {
//        "address_id": 30,
//        "street": "1919 Ocean Lane",
//        "city": "Vadodara",
//        "state": "Gujarat",
//        "postal_code": "390001",
//        "country": "India"
//    }
//}
//
//			""";
// 
//	private	String usersbyname = "/api/v1/users/name/Simran Agarwal"; 
//	String expectedusersbyname = 
//			"""
//[
//    {
//        "user_id": 19,
//        "email": "simran.agarwal@example.in",
//        "name": "Simran Agarwal",
//        "balance": 4900.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 39,
//            "street": "2828 Star Avenue",
//            "city": "Nashik",
//            "state": "Maharashtra",
//            "postal_code": "422001",
//            "country": "India"
//        }
//    }
//]
//			""";
// 
//	private	String usersbycity = "/api/v1/users/by_city/Gandhinagar"; 
//	String expectedusersbycity = 
//			"""
//	[
//    {
//        "user_id": 17,
//        "email": "quincy.singh@example.in",
//        "name": "Quincy Singh",
//        "balance": 5700.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 37,
//            "street": "2626 Horizon Street",
//            "city": "Gandhinagar",
//            "state": "Gujarat",
//            "postal_code": "382001",
//            "country": "India"
//        }
//    }
//]
//""";
//
//	private	String usersstate = "/api/v1/users/by_state/Gujarat"; 
//	String expectedusersbystate ="""
//			[
//    {
//        "user_id": 8,
//        "email": "hitesh.rawat@example.in",
//        "name": "Hitesh Rawat",
//        "balance": 3900.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 28,
//            "street": "1717 Mountain Avenue",
//            "city": "Surat",
//            "state": "Gujarat",
//            "postal_code": "395001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 10,
//        "email": "jay.patel@example.in",
//        "name": "Jay Patel",
//        "balance": 5800.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 33,
//        "email": "pradeep.kumar@example.in",
//        "name": "Pradeep Kumar",
//        "balance": 20000.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 44,
//        "email": "arjun.sharma@example.in",
//        "name": "Arjun Sharma",
//        "balance": 2100.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 55,
//        "email": "leena.nair@example.in",
//        "name": "Leena Nair",
//        "balance": 1400.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 58,
//        "email": "omkar.singh@example.in",
//        "name": "Omkar Singh",
//        "balance": 1400.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 68,
//        "email": "zahir.khan@example.in",
//        "name": "Zahir Khan",
//        "balance": 2100.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 70,
//        "email": "ajay.patel@example.in",
//        "name": "Jay Patel",
//        "balance": 9000.0,
//        "created_at": "2024-03-18T09:27:30",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 81,
//        "email": "ekansh.thakur@example.in",
//        "name": "Ekansh Thakur",
//        "balance": 1500.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 30,
//            "street": "1919 Ocean Lane",
//            "city": "Vadodara",
//            "state": "Gujarat",
//            "postal_code": "390001",
//            "country": "India"
//        }
//    },
//    {
//        "user_id": 17,
//        "email": "quincy.singh@example.in",
//        "name": "Quincy Singh",
//        "balance": 5700.0,
//        "created_at": "2024-03-18T12:41:49",
//        "addresses": {
//            "address_id": 37,
//            "street": "2626 Horizon Street",
//            "city": "Gandhinagar",
//            "state": "Gujarat",
//            "postal_code": "382001",
//            "country": "India"
//        }
//    }
//]
//			
//			""";
//	
//	
//
//
// 
//    @Autowired
//    private TestRestTemplate template;
//	@Test
//	public void testusersbyid1() throws JSONException, org.json.JSONException {
//		ResponseEntity<String> response = template.getForEntity(usersbyid1, String.class);
//        System.out.println(response.getBody());
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getHeaders());
//		assertEquals("application/json",
//				response.getHeaders().get("Content-Type").get(0));
//		assertTrue(response.getStatusCode().is2xxSuccessful());
//		JSONAssert.assertEquals(expectedusersbyid1, response.getBody(), false);
////        assertEquals("application/json", response.getHeaders().getContentType().toString());
////        JSONAssert.assertEquals(expectedrestaurantbyid1, response.getBody(), false);
//	}
//	@Test
//	public void testusersbyname() throws JSONException, org.json.JSONException {
//		ResponseEntity<String> response = template.getForEntity(usersbyname, String.class);
//        System.out.println(response.getBody());
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getHeaders());
//		assertEquals("application/json",
//				response.getHeaders().get("Content-Type").get(0));
//		assertTrue(response.getStatusCode().is2xxSuccessful());
//		JSONAssert.assertEquals(expectedusersbyname, response.getBody(), false);
////        assertEquals("application/json", response.getHeaders().getContentType().toString());
////        JSONAssert.assertEquals(expectedrestaurantbyid1, response.getBody(), false);
//	}
// 
//	@Test
//	public void testusersbystate() throws JSONException, org.json.JSONException {
//		ResponseEntity<String> response = template.getForEntity(usersstate, String.class);
//        System.out.println(response.getBody());
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getHeaders());
//		assertEquals("application/json",
//				response.getHeaders().get("Content-Type").get(0));
//		assertTrue(response.getStatusCode().is2xxSuccessful());
//		JSONAssert.assertEquals(expectedusersbystate, response.getBody(), false);
////        assertEquals("application/json", response.getHeaders().getContentType().toString());
////        JSONAssert.assertEquals(expectedrestaurantbyid, response.getBody(), false);
//	}
//
//	@Test
//	public void testusersbycity() throws JSONException, org.json.JSONException {
//		ResponseEntity<String> response = template.getForEntity(usersbycity, String.class);
//        System.out.println(response.getBody());
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getHeaders());
//		assertEquals("application/json",
//				response.getHeaders().get("Content-Type").get(0));
//		assertTrue(response.getStatusCode().is2xxSuccessful());
//		JSONAssert.assertEquals(expectedusersbycity, response.getBody(), false);
////        assertEquals("application/json", response.getHeaders().getContentType().toString());
////        JSONAssert.assertEquals(expectedrestaurantbyid, response.getBody(), false);
//	}
//	
//	
//	@Test
//	public void retrieveCategoriesById() throws JSONException
//	{
//	String endpoint="http://localhost:1234/api/v1/users/sandy";
//	String Users="""
//					{
//						"user_id": 1
//					}
//				""";
//	int user_id=-1;
//	try {
//		user_id = Validation.extractId(endpoint);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	assertFalse(user_id >= 0, "Expected user_id to be a positive integer");	
////	ResponseEntity<String> response = template.getForEntity(endpoint, String.class);
////	assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
////	assertTrue(response.getStatusCode().is2xxSuccessful());
////	JSONAssert.assertEquals(Users,response.getBody(), false);
////	assertEquals("keep-alive",response.getHeaders().get("Connection").get(0));
//  }
//	
//	
//	
//	
//	
//	private static String endpoint1 ="http://localhost:1234/api/v1/vendor/4";
//		String output1 = """
//	{
//	    "vendor_id": 4,
//	    "vendorName": "Radiant Ornaments",
//	    "description": "Reflecting radiance through meticulously crafted gold pieces",
//	    "contact_person_name": "Sakshi Gupta",
//	    "contactemail": "sakshi.radiant@example.com",
//	    "contact_phone": "+91 9876785678",
//	    "website_url": "https://www.radiantornaments.in",
//	    "total_gold_quantity": 4500.0,
//	    "current_gold_price": 6400.0,
//	    "created_at": "2024-03-18T12:41:49"
//	}
//	""";
//		private static String endpoint2 ="http://localhost:1234/api/v1/vendor_branches/2";
//		String output2="""
//		{
//	    "branch_id": 2,
//	    "quantity": 880.0,
//	    "created_at": "2024-03-18T12:41:49",
//	    "addresses": {
//	        "address_id": 2,
//	        "street": "456 Oak Avenue",
//	        "city": "Delhi",
//	        "state": "Delhi",
//	        "postal_code": "110001",
//	        "country": "India"
//	    },
//	    "vendors": {
//	        "vendor_id": 2,
//	        "vendorName": "Golden Heritage",
//	        "description": "Preserving India’s rich heritage in gold craftsmanship",
//	        "contact_person_name": "Ananya Kapoor",
//	        "contactemail": "ananya.goldenheritage@example.com",
//	        "contact_phone": "+91 9871239876",
//	        "website_url": "https://www.goldenheritageindia.in",
//	        "total_gold_quantity": 2800.0,
//	        "current_gold_price": 6400.0,
//	        "created_at": "2024-03-18T12:41:49"
//	    }
//	}
//				""";
//		private static String endpoint3 ="http://localhost:1234/api/v1/vendor/name/Radiant Ornaments";
//		String output3="""
//	{
//	    "vendor_id": 4,
//	    "vendorName": "Radiant Ornaments",
//	    "description": "Reflecting radiance through meticulously crafted gold pieces",
//	    "contact_person_name": "Sakshi Gupta",
//	    "contactemail": "sakshi.radiant@example.com",
//	    "contact_phone": "+91 9876785678",
//	    "website_url": "https://www.radiantornaments.in",
//	    "total_gold_quantity": 4500.0,
//	    "current_gold_price": 6400.0,
//	    "created_at": "2024-03-18T12:41:49"
//	}
//				""";
//		private static String endpoint4 ="http://localhost:1234/api/v1/vendor_branches/by_city/Mumbai";
//		String output4="""
//		[
//	    {
//	        "branch_id": 1,
//	        "quantity": 1658.0,
//	        "created_at": "2024-03-18T12:41:49",
//	        "addresses": {
//	            "address_id": 1,
//	            "street": "123 Main Street",
//	            "city": "Mumbai",
//	            "state": "Maharashtra",
//	            "postal_code": "400001",
//	            "country": "India"
//	        },
//	        "vendors": {
//	            "vendor_id": 1,
//	            "vendorName": "Sona Jewelers",
//	            "description": "Your trusted source for authentic gold jewelry",
//	            "contact_person_name": "Rohit Verma",
//	            "contactemail": "rohit.sona@example.com",
//	            "contact_phone": "+91 9876541230",
//	            "website_url": "https://www.sonajewelers.com",
//	            "total_gold_quantity": 2200.0,
//	            "current_gold_price": 6400.0,
//	            "created_at": "2024-03-18T12:41:49"
//	        }
//	    }
//	]
//				""";
//
//		private static String endpoint5 ="http://localhost:1234/api/v1/vendor_branches/by_state/Karnataka";
//		String output5="""
//		[
//	    {
//	        "branch_id": 3,
//	        "quantity": 1927.0,
//	        "created_at": "2024-03-18T12:41:49",
//	        "addresses": {
//	            "address_id": 3,
//	            "street": "789 Pine Road",
//	            "city": "Bangalore",
//	            "state": "Karnataka",
//	            "postal_code": "560001",
//	            "country": "India"
//	        },
//	        "vendors": {
//	            "vendor_id": 3,
//	            "vendorName": "Regal Gold Emporium",
//	            "description": "Exuding regality through our gold collections",
//	            "contact_person_name": "Aryan Singh",
//	            "contactemail": "aryan.regalgold@example.com",
//	            "contact_phone": "+91 9887612345",
//	            "website_url": "https://www.regalgoldemporium.com",
//	            "total_gold_quantity": 1600.0,
//	            "current_gold_price": 6400.0,
//	            "created_at": "2024-03-18T12:41:49"
//	        }
//	    },
//	    {
//	        "branch_id": 48,
//	        "quantity": 1788.0,
//	        "created_at": "2024-03-18T12:41:49",
//	        "addresses": {
//	            "address_id": 48,
//	            "street": "3737 Stardust Road",
//	            "city": "Mangalore",
//	            "state": "Karnataka",
//	            "postal_code": "575001",
//	            "country": "India"
//	        },
//	        "vendors": {
//	            "vendor_id": 48,
//	            "vendorName": "Harmony Gold Studios",
//	            "description": "Harmonizing beauty and craftsmanship in every gold creation",
//	            "contact_person_name": "Kavya Singh",
//	            "contactemail": "kavya.harmonygold@example.com",
//	            "contact_phone": "+91 9870123456",
//	            "website_url": "https://www.harmonygoldstudios.in",
//	            "total_gold_quantity": 1800.0,
//	            "current_gold_price": 6400.0,
//	            "created_at": "2024-03-18T12:41:49"
//	        }
//	    }
//	]
//				""";
//
//		@Test
//		public void Orderstest1() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint1, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output1,response.getBody(),true);
//		}
//		@Test
//		public void Orderstest2() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint2, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output2,response.getBody(),true);
//		}
//		@Test
//		public void Orderstest3() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint3, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output3,response.getBody(),true);
//		}
//		@Test
//		public void Orderstest4() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint4, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output4,response.getBody(),true);
//		}
//		@Test
//		public void Orderstest5() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint5, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output5,response.getBody(),true);
//		}
//		@Test
//		public void retrieveVendorsById() throws JSONException
//		{
//		String endpoint="http://localhost:1234/api/v1/vendor/malli";
//		String vendorid="""
//						{
//							"vendor_id": 4
//						}
//					""";
//		int vendor_id =-1;
//		try {
//			vendor_id = Validation.extractId(endpoint);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertFalse(vendor_id >= 0, "Expected user_id to be a positive integer");	
////		ResponseEntity<String> response = template.getForEntity(endpoint, String.class);
////		assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
////		assertTrue(response.getStatusCode().is2xxSuccessful());
////		JSONAssert.assertEquals(vendorid,response.getBody(), false);
////		assertEquals("keep-alive",response.getHeaders().get("Connection").get(0));
//	  }
//	
//	
//	
//	
//		private	String transactionsbyid1 = "/api/v1/transaction_history/by_user/2"; 
//		String expectedtransactionsbyid1 = 
//				"""
//		[
//	    {
//	        "transaction_id": 2,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 18.0,
//	        "amount": 102600.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 2,
//	            "email": "bhuvan.sharma@example.in",
//	            "name": "Bhuvan Sharma",
//	            "balance": 6800.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 22,
//	                "street": "1011 Violet Road",
//	                "city": "Thiruvananthapuram",
//	                "state": "Kerala",
//	                "postal_code": "695001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 2,
//	            "quantity": 1253.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 2,
//	                "street": "456 Oak Avenue",
//	                "city": "Delhi",
//	                "state": "Delhi",
//	                "postal_code": "110001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 2,
//	                "vendorName": "Golden Heritage",
//	                "description": "Preserving India’s rich heritage in gold craftsmanship",
//	                "contact_person_name": "Ananya Kapoor",
//	                "contactemail": "ananya.goldenheritage@example.com",
//	                "contact_phone": "+91 9871239876",
//	                "website_url": "https://www.goldenheritageindia.in",
//	                "total_gold_quantity": 2800.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    }
//	]
//				""";
//	 
//	 
//		private	String payment = "/api/v1/payments/by_payment_method/CreditCard"; 
//		String expectedpaymet = 
//				"""
//		[
//	    {
//	        "payment_id": 1,
//	        "amount": 55862.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 1,
//	            "email": "aman.gupta@example.in",
//	            "name": "Aman Gupta",
//	            "balance": 5500.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 21,
//	                "street": "909 Magnolia Street",
//	                "city": "Varanasi",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "221001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 7,
//	        "amount": 63801.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 7,
//	            "email": "geeta.singh@example.in",
//	            "name": "Geeta Singh",
//	            "balance": 2800.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 27,
//	                "street": "1616 Cloud Lane",
//	                "city": "Dehradun",
//	                "state": "Uttarakhand",
//	                "postal_code": "248001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 13,
//	        "amount": 65987.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Failed",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 13,
//	            "email": "mira.sharma@example.in",
//	            "name": "Mira Sharma",
//	            "balance": 3100.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 33,
//	                "street": "2222 Forest Road",
//	                "city": "Jodhpur",
//	                "state": "Rajasthan",
//	                "postal_code": "342001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 19,
//	        "amount": 88969.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Failed",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 19,
//	            "email": "simran.agarwal@example.in",
//	            "name": "Simran Agarwal",
//	            "balance": 4900.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 39,
//	                "street": "2828 Star Avenue",
//	                "city": "Nashik",
//	                "state": "Maharashtra",
//	                "postal_code": "422001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 25,
//	        "amount": 63099.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 25,
//	            "email": "yamini.patel@example.in",
//	            "name": "Yamini Patel",
//	            "balance": 3400.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 45,
//	                "street": "3434 Planet Avenue",
//	                "city": "Gurgaon",
//	                "state": "Haryana",
//	                "postal_code": "122001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 31,
//	        "amount": 28761.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 31,
//	            "email": "nishant.sharma@example.in",
//	            "name": "Nishant Sharma",
//	            "balance": 1000.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 20,
//	                "street": "808 Lily Lane",
//	                "city": "Faridabad",
//	                "state": "Haryana",
//	                "postal_code": "121001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 37,
//	        "amount": 80544.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 37,
//	            "email": "tarun.agarwal@example.in",
//	            "name": "Tarun Agarwal",
//	            "balance": 1400.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 50,
//	                "street": "3939 Galaxy Avenue",
//	                "city": "Tiruchirappalli",
//	                "state": "Tamil Nadu",
//	                "postal_code": "620001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 43,
//	        "amount": 2303.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 43,
//	            "email": "zara.kapoor@example.in",
//	            "name": "Zara Kapoor",
//	            "balance": 4300.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 25,
//	                "street": "1414 Sun Lane",
//	                "city": "Guwahati",
//	                "state": "Assam",
//	                "postal_code": "781001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 49,
//	        "amount": 56475.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-17T20:04:15",
//	        "users": {
//	            "user_id": 49,
//	            "email": "farhan.khan@example.in",
//	            "name": "Farhan Khan",
//	            "balance": 6500.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 1,
//	                "street": "123 Main Street",
//	                "city": "Mumbai",
//	                "state": "Maharashtra",
//	                "postal_code": "400001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 51,
//	        "amount": 8557454.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Success",
//	        "created_at": "2024-03-14T16:47:23",
//	        "users": {
//	            "user_id": 1,
//	            "email": "aman.gupta@example.in",
//	            "name": "Aman Gupta",
//	            "balance": 5500.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 21,
//	                "street": "909 Magnolia Street",
//	                "city": "Varanasi",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "221001",
//	                "country": "India"
//	            }
//	        }
//	    },
//	    {
//	        "payment_id": 52,
//	        "amount": 81188.0,
//	        "payment_method": "CreditCard",
//	        "transaction_type": "Creditedtowallet",
//	        "payment_status": "Failed",
//	        "created_at": "2024-03-15T15:07:13",
//	        "users": {
//	            "user_id": 56,
//	            "email": "mohan.goswami@example.in",
//	            "name": "Mohan Goswami",
//	            "balance": 2000.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 35,
//	                "street": "2424 Oasis Lane",
//	                "city": "Ghaziabad",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "201001",
//	                "country": "India"
//	            }
//	        }
//	    }
//	]
//				""";
//		private	String paymentsbyid = "/api/v1/payments/10"; 
//		String expectedpaymentsbyid = 
//				"""
//		 {
//	    "payment_id": 10,
//	    "amount": 20195.0,
//	    "payment_method": "BankTransfer",
//	    "transaction_type": "Debitedfromwallet",
//	    "payment_status": "Success",
//	    "created_at": "2024-03-17T20:04:15",
//	    "users": {
//	        "user_id": 10,
//	        "email": "jay.patel@example.in",
//	        "name": "Jay Patel",
//	        "balance": 5800.0,
//	        "created_at": "2024-03-17T20:04:15",
//	        "addresses": {
//	            "address_id": 30,
//	            "street": "1919 Ocean Lane",
//	            "city": "Vadodara",
//	            "state": "Gujarat",
//	            "postal_code": "390001",
//	            "country": "India"
//	        }
//	    }
//	}
//				""";
//	
//	
//	
//	
//		private	String transactiontype = "/api/v1/transaction_history/by_type/Sell"; 
//		String expectedtransactiontype = 
//		"""
//		[
//	    {
//	        "transaction_id": 2,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 18.0,
//	        "amount": 102600.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 2,
//	            "email": "bhuvan.sharma@example.in",
//	            "name": "Bhuvan Sharma",
//	            "balance": 6800.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 22,
//	                "street": "1011 Violet Road",
//	                "city": "Thiruvananthapuram",
//	                "state": "Kerala",
//	                "postal_code": "695001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 2,
//	            "quantity": 1253.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 2,
//	                "street": "456 Oak Avenue",
//	                "city": "Delhi",
//	                "state": "Delhi",
//	                "postal_code": "110001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 2,
//	                "vendorName": "Golden Heritage",
//	                "description": "Preserving India’s rich heritage in gold craftsmanship",
//	                "contact_person_name": "Ananya Kapoor",
//	                "contactemail": "ananya.goldenheritage@example.com",
//	                "contact_phone": "+91 9871239876",
//	                "website_url": "https://www.goldenheritageindia.in",
//	                "total_gold_quantity": 2800.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 5,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 20.0,
//	        "amount": 114000.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 5,
//	            "email": "esha.verma@example.in",
//	            "name": "Esha Verma",
//	            "balance": 5100.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 25,
//	                "street": "1414 Sun Lane",
//	                "city": "Guwahati",
//	                "state": "Assam",
//	                "postal_code": "781001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 5,
//	            "quantity": 1058.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 5,
//	                "street": "202 Maple Street",
//	                "city": "Kolkata",
//	                "state": "West Bengal",
//	                "postal_code": "700001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 5,
//	                "vendorName": "Om Shri Jewels",
//	                "description": "Blending spirituality with exquisite gold jewelry",
//	                "contact_person_name": "Aditya Sharma",
//	                "contactemail": "aditya.omshri@example.com",
//	                "contact_phone": "+91 9873458765",
//	                "website_url": "https://www.omshrijewels.com",
//	                "total_gold_quantity": 1200.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 8,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 10.0,
//	        "amount": 57000.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 8,
//	            "email": "hitesh.rawat@example.in",
//	            "name": "Hitesh Rawat",
//	            "balance": 3900.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 28,
//	                "street": "1717 Mountain Avenue",
//	                "city": "Surat",
//	                "state": "Gujarat",
//	                "postal_code": "395001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 8,
//	            "quantity": 832.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 8,
//	                "street": "505 Olive Road",
//	                "city": "Ahmedabad",
//	                "state": "Gujarat",
//	                "postal_code": "380001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 8,
//	                "vendorName": "Shubh Gold Crafts",
//	                "description": "Crafting auspicious gold pieces for your special moments",
//	                "contact_person_name": "Kunal Verma",
//	                "contactemail": "kunal.shubhgold@example.com",
//	                "contact_phone": "+91 9873456789",
//	                "website_url": "https://www.shubhgoldcrafts.com",
//	                "total_gold_quantity": 4200.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 11,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 12.0,
//	        "amount": 68400.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 11,
//	            "email": "kavya.mehta@example.in",
//	            "name": "Kavya Mehta",
//	            "balance": 3200.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 31,
//	                "street": "2020 Harbor Street",
//	                "city": "Raipur",
//	                "state": "Chhattisgarh",
//	                "postal_code": "492001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 11,
//	            "quantity": 1499.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 11,
//	                "street": "808 Apple Street",
//	                "city": "Kanpur",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "208001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 11,
//	                "vendorName": "Divine Gold Exports",
//	                "description": "Exporting divine craftsmanship in gold worldwide",
//	                "contact_person_name": "Ritu Kapoor",
//	                "contactemail": "ritu.divinegold@example.com",
//	                "contact_phone": "+91 9871234567",
//	                "website_url": "https://www.divinegoldexports.com",
//	                "total_gold_quantity": 3600.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 14,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 18.0,
//	        "amount": 102600.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 14,
//	            "email": "nishit.gupta@example.in",
//	            "name": "Nishit Gupta",
//	            "balance": 4600.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 34,
//	                "street": "2323 Desert Avenue",
//	                "city": "Amritsar",
//	                "state": "Punjab",
//	                "postal_code": "143001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 14,
//	            "quantity": 922.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 14,
//	                "street": "202 Sunflower Street",
//	                "city": "Thane",
//	                "state": "Maharashtra",
//	                "postal_code": "400601",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 14,
//	                "vendorName": "Aureate Elegance",
//	                "description": "Elegance personified through our exquisite gold collections",
//	                "contact_person_name": "Rohini Gupta",
//	                "contactemail": "rohini.aureate@example.com",
//	                "contact_phone": "+91 9874567890",
//	                "website_url": "https://www.aureateelegance.in",
//	                "total_gold_quantity": 4800.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 17,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 22.0,
//	        "amount": 125400.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 17,
//	            "email": "quincy.singh@example.in",
//	            "name": "Quincy Singh",
//	            "balance": 5700.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 37,
//	                "street": "2626 Horizon Street",
//	                "city": "Gandhinagar",
//	                "state": "Gujarat",
//	                "postal_code": "382001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 17,
//	            "quantity": 1313.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 17,
//	                "street": "505 Lotus Lane",
//	                "city": "Agra",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "282001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 17,
//	                "vendorName": "Eternal Gold Legacy",
//	                "description": "Carrying forward the legacy of eternal gold craftsmanship",
//	                "contact_person_name": "Arnav Singh",
//	                "contactemail": "arnav.eternalgold@example.com",
//	                "contact_phone": "+91 9877890123",
//	                "website_url": "https://www.eternalgoldlegacy.com",
//	                "total_gold_quantity": 3300.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 20,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 10.0,
//	        "amount": 57000.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 20,
//	            "email": "tushar.jain@example.in",
//	            "name": "Tushar Jain",
//	            "balance": 5400.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 40,
//	                "street": "2929 Galaxy Road",
//	                "city": "Allahabad",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "211001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 20,
//	            "quantity": 1653.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 20,
//	                "street": "808 Lily Lane",
//	                "city": "Faridabad",
//	                "state": "Haryana",
//	                "postal_code": "121001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 20,
//	                "vendorName": "Ethereal Gold Artistry",
//	                "description": "Artistry that transcends the ordinary in gold craftsmanship",
//	                "contact_person_name": "Ishita Verma",
//	                "contactemail": "ishita.etherealgold@example.com",
//	                "contact_phone": "+91 9870123456",
//	                "website_url": "https://www.etherealgoldartistry.in",
//	                "total_gold_quantity": 1800.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 22,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Failed",
//	        "quantity": 12.0,
//	        "amount": 68400.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 22,
//	            "email": "vishal.rawat@example.in",
//	            "name": "Vishal Rawat",
//	            "balance": 4700.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 42,
//	                "street": "3131 Nebula Street",
//	                "city": "Howrah",
//	                "state": "West Bengal",
//	                "postal_code": "711001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 22,
//	            "quantity": 1879.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 22,
//	                "street": "1011 Violet Road",
//	                "city": "Thiruvananthapuram",
//	                "state": "Kerala",
//	                "postal_code": "695001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 22,
//	                "vendorName": "Majestic Gold Studios",
//	                "description": "Capturing the majesty of gold in every jewelry creation",
//	                "contact_person_name": "Tanishka Gupta",
//	                "contactemail": "tanishka.majesticgold@example.com",
//	                "contact_phone": "+91 9872345678",
//	                "website_url": "https://www.majesticgoldstudios.in",
//	                "total_gold_quantity": 2700.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 25,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Failed",
//	        "quantity": 32.0,
//	        "amount": 182400.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 25,
//	            "email": "yamini.patel@example.in",
//	            "name": "Yamini Patel",
//	            "balance": 3400.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 45,
//	                "street": "3434 Planet Avenue",
//	                "city": "Gurgaon",
//	                "state": "Haryana",
//	                "postal_code": "122001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 25,
//	            "quantity": 725.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 25,
//	                "street": "1414 Sun Lane",
//	                "city": "Guwahati",
//	                "state": "Assam",
//	                "postal_code": "781001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 25,
//	                "vendorName": "Celestial Gold Designs",
//	                "description": "Designs that reach the celestial heights of gold elegance",
//	                "contact_person_name": "Aryan Gupta",
//	                "contactemail": "aryan.celestialgold@example.com",
//	                "contact_phone": "+91 9875678901",
//	                "website_url": "https://www.celestialgolddesigns.com",
//	                "total_gold_quantity": 3000.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 28,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Failed",
//	        "quantity": 28.0,
//	        "amount": 159600.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 28,
//	            "email": "bhavin.gupta@example.in",
//	            "name": "Bhavin Gupta",
//	            "balance": 4300.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 48,
//	                "street": "3737 Stardust Road",
//	                "city": "Mangalore",
//	                "state": "Karnataka",
//	                "postal_code": "575001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 28,
//	            "quantity": 810.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 28,
//	                "street": "1717 Mountain Avenue",
//	                "city": "Surat",
//	                "state": "Gujarat",
//	                "postal_code": "395001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 28,
//	                "vendorName": "Golden Essence",
//	                "description": "Capturing the essence of gold in every piece of jewelry",
//	                "contact_person_name": "Aanya Singh",
//	                "contactemail": "aanya.goldenessence@example.com",
//	                "contact_phone": "+91 9878901234",
//	                "website_url": "https://www.goldenessence.co.in",
//	                "total_gold_quantity": 3700.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 32,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 25.0,
//	        "amount": 142500.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 32,
//	            "email": "oprah.verma@example.in",
//	            "name": "Oprah Verma",
//	            "balance": 3500.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 25,
//	                "street": "1414 Sun Lane",
//	                "city": "Guwahati",
//	                "state": "Assam",
//	                "postal_code": "781001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 32,
//	            "quantity": 1510.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 32,
//	                "street": "2121 Beach Lane",
//	                "city": "Jamshedpur",
//	                "state": "Jharkhand",
//	                "postal_code": "831001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 32,
//	                "vendorName": "Pure Elegance Gold",
//	                "description": "Pure elegance personified in our gold jewelry designs",
//	                "contact_person_name": "Anika Patel",
//	                "contactemail": "anika.pureelegance@example.com",
//	                "contact_phone": "+91 9872345678",
//	                "website_url": "https://www.pureelegancegold.com",
//	                "total_gold_quantity": 2200.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 35,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 20.0,
//	        "amount": 114000.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 35,
//	            "email": "rajan.mehta@example.in",
//	            "name": "Rajan Mehta",
//	            "balance": 4500.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 40,
//	                "street": "2929 Galaxy Road",
//	                "city": "Allahabad",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "211001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 35,
//	            "quantity": 1565.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 35,
//	                "street": "2424 Oasis Lane",
//	                "city": "Ghaziabad",
//	                "state": "Uttar Pradesh",
//	                "postal_code": "201001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 35,
//	                "vendorName": "Enchanting Gold Studios",
//	                "description": "Enchanting souls with our spellbinding gold designs",
//	                "contact_person_name": "Dev Kapoor",
//	                "contactemail": "dev.enchantinggold@example.com",
//	                "contact_phone": "+91 9875678901",
//	                "website_url": "https://www.enchantinggoldstudios.in",
//	                "total_gold_quantity": 2900.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 38,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 15.0,
//	        "amount": 85500.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 38,
//	            "email": "urvashi.singh@example.in",
//	            "name": "Urvashi Singh",
//	            "balance": 1800.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 1,
//	                "street": "123 Main Street",
//	                "city": "Mumbai",
//	                "state": "Maharashtra",
//	                "postal_code": "400001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 38,
//	            "quantity": 1423.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 38,
//	                "street": "2727 Sky Lane",
//	                "city": "Bhubaneswar",
//	                "state": "Odisha",
//	                "postal_code": "751001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 38,
//	                "vendorName": "Serene Gold Arts",
//	                "description": "Crafting serenity through the artistry of gold",
//	                "contact_person_name": "Siya Verma",
//	                "contactemail": "siya.serenegold@example.com",
//	                "contact_phone": "+91 9878901234",
//	                "website_url": "https://www.serenegoldarts.co.in",
//	                "total_gold_quantity": 3500.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 41,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 12.0,
//	        "amount": 68400.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 41,
//	            "email": "xena.thomas@example.in",
//	            "name": "Xena Thomas",
//	            "balance": 3000.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 15,
//	                "street": "303 Rose Avenue",
//	                "city": "Bhopal",
//	                "state": "Madhya Pradesh",
//	                "postal_code": "462001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 41,
//	            "quantity": 584.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 41,
//	                "street": "3030 Comet Lane",
//	                "city": "Cuttack",
//	                "state": "Odisha",
//	                "postal_code": "753001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 41,
//	                "vendorName": "Lustrous Gold Designs",
//	                "description": "Lustrous designs that define the essence of gold",
//	                "contact_person_name": "Yash Patel",
//	                "contactemail": "yash.lustrousgold@example.com",
//	                "contact_phone": "+91 9871234567",
//	                "website_url": "https://www.lustrousgolddesigns.co.in",
//	                "total_gold_quantity": 1600.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 44,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 18.0,
//	        "amount": 102600.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 44,
//	            "email": "arjun.sharma@example.in",
//	            "name": "Arjun Sharma",
//	            "balance": 2100.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 30,
//	                "street": "1919 Ocean Lane",
//	                "city": "Vadodara",
//	                "state": "Gujarat",
//	                "postal_code": "390001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 44,
//	            "quantity": 1864.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 44,
//	                "street": "3333 Cosmos Lane",
//	                "city": "Dhanbad",
//	                "state": "Jharkhand",
//	                "postal_code": "826001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 44,
//	                "vendorName": "Golden Symphony Crafts",
//	                "description": "Creating a symphony of beauty with our gold craftsmanship",
//	                "contact_person_name": "Riya Patel",
//	                "contactemail": "riya.goldensymphony@example.com",
//	                "contact_phone": "+91 9874567890",
//	                "website_url": "https://www.goldensymphonycrafts.in",
//	                "total_gold_quantity": 1800.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 47,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 22.0,
//	        "amount": 125400.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 47,
//	            "email": "deepika.sharma@example.in",
//	            "name": "Deepika Sharma",
//	            "balance": 1100.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 45,
//	                "street": "3434 Planet Avenue",
//	                "city": "Gurgaon",
//	                "state": "Haryana",
//	                "postal_code": "122001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 47,
//	            "quantity": 764.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 47,
//	                "street": "3636 Comet Lane",
//	                "city": "Rourkela",
//	                "state": "Odisha",
//	                "postal_code": "769001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 47,
//	                "vendorName": "Golden Traditions",
//	                "description": "Preserving and celebrating golden traditions through jewelry",
//	                "contact_person_name": "Arnav Kapoor",
//	                "contactemail": "arnav.goldentraditions@example.com",
//	                "contact_phone": "+91 9876543210",
//	                "website_url": "https://www.goldentraditionsindia.com",
//	                "total_gold_quantity": 2300.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    },
//	    {
//	        "transaction_id": 50,
//	        "transaction_type": "Sell",
//	        "transaction_status": "Success",
//	        "quantity": 10.0,
//	        "amount": 57000.0,
//	        "created_at": "2024-03-18T17:12:31",
//	        "users": {
//	            "user_id": 50,
//	            "email": "gaurav.rawat@example.in",
//	            "name": "Gaurav Rawat",
//	            "balance": 6800.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 5,
//	                "street": "202 Maple Street",
//	                "city": "Kolkata",
//	                "state": "West Bengal",
//	                "postal_code": "700001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 50,
//	            "quantity": 1305.0,
//	            "created_at": "2024-03-17T20:04:15",
//	            "addresses": {
//	                "address_id": 50,
//	                "street": "3939 Galaxy Avenue",
//	                "city": "Tiruchirappalli",
//	                "state": "Tamil Nadu",
//	                "postal_code": "620001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 50,
//	                "vendorName": "Golden Silhouettes",
//	                "description": "Crafting gold silhouettes that tell unique stories",
//	                "contact_person_name": "Anika Verma",
//	                "contactemail": "anika.goldensilhouettes@example.com",
//	                "contact_phone": "+91 9878901234",
//	                "website_url": "https://www.goldensilhouettes.in",
//	                "total_gold_quantity": 1900.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-17T20:04:15"
//	            }
//	        }
//	    }
//	]
//		""";
//		
//		
//		@Test
//		public void testtransactionsbyid1() throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(transactionsbyid1, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedtransactionsbyid1, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(expectedrestaurantbyid1, response.getBody(), false);
//		}
//		@Test
//		public void testpaymentsbyid() throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(paymentsbyid, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedpaymentsbyid, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(expectedrestaurantbyid1, response.getBody(), false);
//		}
//	 
//		@Test
//		public void testpayment() throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(payment, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedpaymet, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(expectedrestaurantbyid, response.getBody(), false);
//		}
//		@Test
//		public void transactionhistorybyid () throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(payment, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedpaymet, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(transactionhistorybyid, response.getBody(), false);
//		}
//	 
//		@Test
//		public void transactiontype() throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(payment, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedpaymet, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(transactionhistorybyid, response.getBody(), false);
//		}
//		@Test
//		public void retrieveTransationsById() throws JSONException
//		{
//		String endpoint="http://localhost:1234/api/v1/transaction_history/vasundara";
//		String transactions="""
//						{
//							"transaction_id": 3
//						}
//					""";
//		int transaction_id=-3;
//		try {
//			transaction_id = Validation.extractId(endpoint);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertFalse(transaction_id >= 0, "Expected trnsaction_id to be a positive integer");	
////		ResponseEntity<String> response = template.getForEntity(endpoint, String.class);
////		assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
////		assertTrue(response.getStatusCode().is2xxSuccessful());
////		JSONAssert.assertEquals(Users,response.getBody(), false);
////		assertEquals("keep-alive",response.getHeaders().get("Connection").get(0));
//	  }
//		
//		
//		//--------------------------------------------------------------------------------------------//
//		
//		
//		private static String endpoint11 = "http://localhost:1234/api/v1/addresses/50";
//		String output11 =	"""
//		[
//	    {
//	        "address_id": 50,
//	        "street": "3939 Galaxy Avenue",
//	        "city": "Tiruchirappalli",
//	        "state": "Tamil Nadu",
//	        "postal_code": "620001",
//	        "country": "India"
//	    }
//	]
//				""";
//
//		private static String endpoint22 = "http://localhost:1234/api/v1/PhysicalGoldTransactions/13";
//		String output22 =	"""
//		{
//	    "transaction_id": 13,
//	    "quantity": 6.75,
//	    "created_at": "2024-03-18T12:41:49",
//	    "user": {
//	        "user_id": 13,
//	        "email": "mira.sharma@example.in",
//	        "name": "Mira Sharma",
//	        "balance": 3100.0,
//	        "created_at": "2024-03-18T12:41:49",
//	        "addresses": {
//	            "address_id": 33,
//	            "street": "2222 Forest Road",
//	            "city": "Jodhpur",
//	            "state": "Rajasthan",
//	            "postal_code": "342001",
//	            "country": "India"
//	        }
//	    },
//	    "vendor_branches": {
//	        "branch_id": 13,
//	        "quantity": 1395.0,
//	        "created_at": "2024-03-18T12:41:49",
//	        "addresses": {
//	            "address_id": 13,
//	            "street": "101 Pinecone Lane",
//	            "city": "Indore",
//	            "state": "Madhya Pradesh",
//	            "postal_code": "452001",
//	            "country": "India"
//	        },
//	        "vendors": {
//	            "vendor_id": 13,
//	            "vendorName": "Golden Glint Studios",
//	            "description": "Capturing the glint of gold in every jewelry piece",
//	            "contact_person_name": "Shivangi Singh",
//	            "contactemail": "shivangi.goldenglint@example.com",
//	            "contact_phone": "+91 9873456789",
//	            "website_url": "https://www.goldenglintstudios.com",
//	            "total_gold_quantity": 2300.0,
//	            "current_gold_price": 6400.0,
//	            "created_at": "2024-03-18T12:41:49"
//	        }
//	    },
//	    "addresses": {
//	        "address_id": 10,
//	        "street": "707 Banana Avenue",
//	        "city": "Lucknow",
//	        "state": "Uttar Pradesh",
//	        "postal_code": "226001",
//	        "country": "India"
//	    }
//	}
//
//				""";
//		private static String endpoint33 = "http://localhost:1234/api/v1/PhysicalGoldTransactions/by_delivery_city/Allahabad";
//		String output33 =	"""
//			[
//	    {
//	        "transaction_id": 9,
//	        "quantity": 4.2,
//	        "created_at": "2024-03-18T12:41:49",
//	        "user": {
//	            "user_id": 9,
//	            "email": "isha.joshi@example.in",
//	            "name": "Isha Joshi",
//	            "balance": 4200.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 29,
//	                "street": "1818 River Road",
//	                "city": "Kochi",
//	                "state": "Kerala",
//	                "postal_code": "682001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 9,
//	            "quantity": 1780.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 9,
//	                "street": "606 Mango Lane",
//	                "city": "Jaipur",
//	                "state": "Rajasthan",
//	                "postal_code": "302001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 9,
//	                "vendorName": "Nirvana Jewels",
//	                "description": "Experience bliss with our ethereal gold jewelry designs",
//	                "contact_person_name": "Tanvi Singh",
//	                "contactemail": "tanvi.nirvanajewels@example.com",
//	                "contact_phone": "+91 9876543219",
//	                "website_url": "https://www.nirvanajewelsindia.com",
//	                "total_gold_quantity": 2900.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-18T12:41:49"
//	            }
//	        },
//	        "addresses": {
//	            "address_id": 40,
//	            "street": "2929 Galaxy Road",
//	            "city": "Allahabad",
//	            "state": "Uttar Pradesh",
//	            "postal_code": "211001",
//	            "country": "India"
//	        }
//	    },
//	    {
//	        "transaction_id": 19,
//	        "quantity": 9.2,
//	        "created_at": "2024-03-18T12:41:49",
//	        "user": {
//	            "user_id": 19,
//	            "email": "simran.agarwal@example.in",
//	            "name": "Simran Agarwal",
//	            "balance": 4900.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 39,
//	                "street": "2828 Star Avenue",
//	                "city": "Nashik",
//	                "state": "Maharashtra",
//	                "postal_code": "422001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 19,
//	            "quantity": 1764.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 19,
//	                "street": "707 Jasmine Road",
//	                "city": "Madurai",
//	                "state": "Tamil Nadu",
//	                "postal_code": "625001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 19,
//	                "vendorName": "Crown Jewels India",
//	                "description": "Fit for royalty – every piece in our gold crown collection",
//	                "contact_person_name": "Aarav Gupta",
//	                "contactemail": "aarav.crownjewels@example.com",
//	                "contact_phone": "+91 9879012345",
//	                "website_url": "https://www.crownjewelsindia.com",
//	                "total_gold_quantity": 4700.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-18T12:41:49"
//	            }
//	        },
//	        "addresses": {
//	            "address_id": 40,
//	            "street": "2929 Galaxy Road",
//	            "city": "Allahabad",
//	            "state": "Uttar Pradesh",
//	            "postal_code": "211001",
//	            "country": "India"
//	        }
//	    },
//	    {
//	        "transaction_id": 29,
//	        "quantity": 5.4,
//	        "created_at": "2024-03-18T12:41:49",
//	        "user": {
//	            "user_id": 29,
//	            "email": "charul.joshi@example.in",
//	            "name": "Charul Joshi",
//	            "balance": 4700.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 49,
//	                "street": "3838 Celestial Lane",
//	                "city": "Siliguri",
//	                "state": "West Bengal",
//	                "postal_code": "734001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 29,
//	            "quantity": 627.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 29,
//	                "street": "1818 River Road",
//	                "city": "Kochi",
//	                "state": "Kerala",
//	                "postal_code": "682001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 29,
//	                "vendorName": "Prism Gold Crafts",
//	                "description": "Creating a prism of colors through our gold craftsmanship",
//	                "contact_person_name": "Aarav Patel",
//	                "contactemail": "aarav.prismgold@example.com",
//	                "contact_phone": "+91 9879012345",
//	                "website_url": "https://www.prismgoldcrafts.in",
//	                "total_gold_quantity": 1200.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-18T12:41:49"
//	            }
//	        },
//	        "addresses": {
//	            "address_id": 40,
//	            "street": "2929 Galaxy Road",
//	            "city": "Allahabad",
//	            "state": "Uttar Pradesh",
//	            "postal_code": "211001",
//	            "country": "India"
//	        }
//	    },
//	    {
//	        "transaction_id": 39,
//	        "quantity": 7.75,
//	        "created_at": "2024-03-18T12:41:49",
//	        "user": {
//	            "user_id": 39,
//	            "email": "vijay.kapoor@example.in",
//	            "name": "Vijay Kapoor",
//	            "balance": 6000.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 5,
//	                "street": "202 Maple Street",
//	                "city": "Kolkata",
//	                "state": "West Bengal",
//	                "postal_code": "700001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 39,
//	            "quantity": 1354.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 39,
//	                "street": "2828 Star Avenue",
//	                "city": "Nashik",
//	                "state": "Maharashtra",
//	                "postal_code": "422001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 39,
//	                "vendorName": "Eternal Elegance",
//	                "description": "Elegance that stands the test of time in gold creations",
//	                "contact_person_name": "Advait Patel",
//	                "contactemail": "advait.eternalelegance@example.com",
//	                "contact_phone": "+91 9879012345",
//	                "website_url": "https://www.eternalelegancegold.com",
//	                "total_gold_quantity": 2700.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-18T12:41:49"
//	            }
//	        },
//	        "addresses": {
//	            "address_id": 40,
//	            "street": "2929 Galaxy Road",
//	            "city": "Allahabad",
//	            "state": "Uttar Pradesh",
//	            "postal_code": "211001",
//	            "country": "India"
//	        }
//	    },
//	    {
//	        "transaction_id": 49,
//	        "quantity": 10.0,
//	        "created_at": "2024-03-18T12:41:49",
//	        "user": {
//	            "user_id": 49,
//	            "email": "farhan.khan@example.in",
//	            "name": "Farhan Khan",
//	            "balance": 6500.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 1,
//	                "street": "123 Main Street",
//	                "city": "Mumbai",
//	                "state": "Maharashtra",
//	                "postal_code": "400001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 49,
//	            "quantity": 1176.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 49,
//	                "street": "3838 Celestial Lane",
//	                "city": "Siliguri",
//	                "state": "West Bengal",
//	                "postal_code": "734001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 49,
//	                "vendorName": "Rustic Gold Designs",
//	                "description": "Embracing rustic charm in modern gold jewelry designs",
//	                "contact_person_name": "Rudra Patel",
//	                "contactemail": "rudra.rusticgold@example.com",
//	                "contact_phone": "+91 9876789012",
//	                "website_url": "https://www.rusticgolddesigns.com",
//	                "total_gold_quantity": 3200.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-18T12:41:49"
//	            }
//	        },
//	        "addresses": {
//	            "address_id": 40,
//	            "street": "2929 Galaxy Road",
//	            "city": "Allahabad",
//	            "state": "Uttar Pradesh",
//	            "postal_code": "211001",
//	            "country": "India"
//	        }
//	    }
//	]		
//
//				""";
//		private static String endpoint44 = "http://localhost:1234/api/v1/PhysicalGoldTransactions/byUser/13";
//		String output44 =	"""
//				[
//	    {
//	        "transaction_id": 13,
//	        "quantity": 6.75,
//	        "created_at": "2024-03-18T12:41:49",
//	        "user": {
//	            "user_id": 13,
//	            "email": "mira.sharma@example.in",
//	            "name": "Mira Sharma",
//	            "balance": 3100.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 33,
//	                "street": "2222 Forest Road",
//	                "city": "Jodhpur",
//	                "state": "Rajasthan",
//	                "postal_code": "342001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 13,
//	            "quantity": 1395.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 13,
//	                "street": "101 Pinecone Lane",
//	                "city": "Indore",
//	                "state": "Madhya Pradesh",
//	                "postal_code": "452001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 13,
//	                "vendorName": "Golden Glint Studios",
//	                "description": "Capturing the glint of gold in every jewelry piece",
//	                "contact_person_name": "Shivangi Singh",
//	                "contactemail": "shivangi.goldenglint@example.com",
//	                "contact_phone": "+91 9873456789",
//	                "website_url": "https://www.goldenglintstudios.com",
//	                "total_gold_quantity": 2300.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-18T12:41:49"
//	            }
//	        },
//	        "addresses": {
//	            "address_id": 10,
//	            "street": "707 Banana Avenue",
//	            "city": "Lucknow",
//	            "state": "Uttar Pradesh",
//	            "postal_code": "226001",
//	            "country": "India"
//	        }
//	    }
//	]
//				""";
//		private static String endpoint55 = "http://localhost:1234/api/v1/PhysicalGoldTransactions/by_branch/9";
//		String output55 =	"""
//
//		[
//	    {
//	        "transaction_id": 9,
//	        "quantity": 4.2,
//	        "created_at": "2024-03-18T12:41:49",
//	        "user": {
//	            "user_id": 9,
//	            "email": "isha.joshi@example.in",
//	            "name": "Isha Joshi",
//	            "balance": 4200.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 29,
//	                "street": "1818 River Road",
//	                "city": "Kochi",
//	                "state": "Kerala",
//	                "postal_code": "682001",
//	                "country": "India"
//	            }
//	        },
//	        "vendor_branches": {
//	            "branch_id": 9,
//	            "quantity": 1780.0,
//	            "created_at": "2024-03-18T12:41:49",
//	            "addresses": {
//	                "address_id": 9,
//	                "street": "606 Mango Lane",
//	                "city": "Jaipur",
//	                "state": "Rajasthan",
//	                "postal_code": "302001",
//	                "country": "India"
//	            },
//	            "vendors": {
//	                "vendor_id": 9,
//	                "vendorName": "Nirvana Jewels",
//	                "description": "Experience bliss with our ethereal gold jewelry designs",
//	                "contact_person_name": "Tanvi Singh",
//	                "contactemail": "tanvi.nirvanajewels@example.com",
//	                "contact_phone": "+91 9876543219",
//	                "website_url": "https://www.nirvanajewelsindia.com",
//	                "total_gold_quantity": 2900.0,
//	                "current_gold_price": 6400.0,
//	                "created_at": "2024-03-18T12:41:49"
//	            }
//	        },
//	        "addresses": {
//	            "address_id": 40,
//	            "street": "2929 Galaxy Road",
//	            "city": "Allahabad",
//	            "state": "Uttar Pradesh",
//	            "postal_code": "211001",
//	            "country": "India"
//	        }
//	    }
//	]
//				""";
//
//		@Test
//		public void Orderstest11() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint11, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output11,response.getBody(),true);
//		}
//	 
//		@Test
//		public void Orderstest22() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint22, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output2,response.getBody(),true);
//		}
//		@Test
//		public void Orderstest33() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint33, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output3,response.getBody(),true);
//		}
//		@Test
//		public void Orderstest44() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint4, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output4,response.getBody(),true);
//		}
//		@Test
//		public void Orderstest55() throws JSONException {
//			ResponseEntity<String> response=template.getForEntity(endpoint55, String.class);
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(output5,response.getBody(),true);
//		}
//		//VALIDATION TESTCASE
//		@Test
//		public void retrievePhysicalGoldById() throws JSONException
//		{
//		String endpoint="http://localhost:1234/api/v1/PhysicalGoldTransactions/sangu";
//		String Users="""
//						{
//							"transaction_id": 1
//						}
//					"""; 
//		int transaction_id=-1;  
//		try {
//			transaction_id = Validation.extractId(endpoint); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertFalse(transaction_id >= 0, "Expected transaction_id to be a positive integer");	
////		ResponseEntity<String> response = template.getForEntity(endpoint, String.class);
////		assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
////		assertTrue(response.getStatusCode().is2xxSuccessful());
////		JSONAssert.assertEquals(Users,response.getBody(), false);
////		assertEquals("keep-alive",response.getHeaders().get("Connection").get(0));
//	  }
//		
//		
////--------------------------------------------------------------------------------------------------------------------//
//		
//		
//		private	String virtualbyuser2 = "/api/v1/virtual_Gold_Holding/users/2"; 
//		String expectedvirtualbyuser2 = 
//				"""
//	    {
//	    "holding_id": 2,
//	    "quantity": 8.75,
//	    "created_at": "2024-03-19T10:26:15",
//	    "users": {
//	        "user_id": 2,
//	        "email": "bhuvan.sharma@example.in",
//	        "name": "Bhuvan Sharma",
//	        "balance": 6800.0,
//	        "created_at": "2024-03-19T10:26:15",
//	        "addresses": {
//	            "address_id": 22,
//	            "street": "1011 Violet Road",
//	            "city": "Thiruvananthapuram",
//	            "state": "Kerala",
//	            "postal_code": "695001",
//	            "country": "India"
//	        }
//	    },
//	    "vendor_branches": {
//	        "branch_id": 2,
//	        "quantity": 596.0,
//	        "created_at": "2024-03-19T10:26:15",
//	        "addresses": {
//	            "address_id": 2,
//	            "street": "456 Oak Avenue",
//	            "city": "Delhi",
//	            "state": "Delhi",
//	            "postal_code": "110001",
//	            "country": "India"
//	        },
//	        "vendors": {
//	            "vendor_id": 2,
//	            "vendorName": "Golden Heritage",
//	            "description": "Preserving India’s rich heritage in gold craftsmanship",
//	            "contact_person_name": "Ananya Kapoor",
//	            "contactemail": "ananya.goldenheritage@example.com",
//	            "contact_phone": "+91 9871239876",
//	            "website_url": "https://www.goldenheritageindia.in",
//	            "total_gold_quantity": 2800.0,
//	            "current_gold_price": 6400.0,
//	            "created_at": "2024-03-19T10:26:15"
//	        }
//	    }
//	}
//	""";
//
//		private	String virtualbyholding = "/api/v1/virtual_Gold_Holding/12"; 
//		String expectedvirtualbyholding = 
//				"""
//		   {
//	    "holding_id": 12,
//	    "quantity": 14.0,
//	    "created_at": "2024-03-19T10:26:15",
//	    "users": {
//	        "user_id": 12,
//	        "email": "lokesh.agarwal@example.in",
//	        "name": "Lokesh Agarwal",
//	        "balance": 4700.0,
//	        "created_at": "2024-03-19T10:26:15",
//	        "addresses": {
//	            "address_id": 32,
//	            "street": "2121 Beach Lane",
//	            "city": "Jamshedpur",
//	            "state": "Jharkhand",
//	            "postal_code": "831001",
//	            "country": "India"
//	        }
//	    },
//	    "vendor_branches": {
//	        "branch_id": 12,
//	        "quantity": 1418.0,
//	        "created_at": "2024-03-19T10:26:15",
//	        "addresses": {
//	            "address_id": 12,
//	            "street": "909 Cherry Road",
//	            "city": "Nagpur",
//	            "state": "Maharashtra",
//	            "postal_code": "440001",
//	            "country": "India"
//	        },
//	        "vendors": {
//	            "vendor_id": 12,
//	            "vendorName": "Sovereign Gold",
//	            "description": "Ruling the gold industry with sovereign craftsmanship",
//	            "contact_person_name": "Siddharth Verma",
//	            "contactemail": "siddharth.sovereigngold@example.com",
//	            "contact_phone": "+91 9872345678",
//	            "website_url": "https://www.sovereigngold.co.in",
//	            "total_gold_quantity": 1000.0,
//	            "current_gold_price": 6400.0,
//	            "created_at": "2024-03-19T10:26:15"
//	        }
//	    }
//	}
//				""";
//		private	String paymentbyid5 = "/api/v1/payments/5"; 
//		String expectedpaymentbyid5 = 
//				"""
//		   {
//	    "payment_id": 5,
//	    "amount": 99916.0,
//	    "payment_method": "PhonePe",
//	    "transaction_type": "Creditedtowallet",
//	    "payment_status": "Success",
//	    "created_at": "2024-03-19T10:26:15",
//	    "users": {
//	        "user_id": 5,
//	        "email": "esha.verma@example.in",
//	        "name": "Esha Verma",
//	        "balance": 5100.0,
//	        "created_at": "2024-03-19T10:26:15",
//	        "addresses": {
//	            "address_id": 25,
//	            "street": "1414 Sun Lane",
//	            "city": "Guwahati",
//	            "state": "Assam",
//	            "postal_code": "781001",
//	            "country": "India"
//	        }
//	    }
//	}
//				""";
//
//	 
//	 
//
//
//	 
//
//	  
//		@Test
//		public void testvendoridby6() throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(virtualbyuser2, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedvirtualbyuser2, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(expectedrestaurantbyid1, response.getBody(), false);
//		}
//		@Test
//		public void testvirtualbyholding() throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(virtualbyholding, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedvirtualbyholding, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(expectedrestaurantbyid1, response.getBody(), false);
//		}
//		@Test
//		public void testpaymentbyid() throws JSONException, org.json.JSONException {
//			ResponseEntity<String> response = template.getForEntity(paymentbyid5, String.class);
//	        System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			assertEquals("application/json",
//					response.getHeaders().get("Content-Type").get(0));
//			assertTrue(response.getStatusCode().is2xxSuccessful());
//			JSONAssert.assertEquals(expectedpaymentbyid5, response.getBody(), false);
////	        assertEquals("application/json", response.getHeaders().getContentType().toString());
////	        JSONAssert.assertEquals(expectedrestaurantbyid1, response.getBody(), false);
//		}
//		private static String all_vgh = "/api/v1/virtual_Gold_Holding";
//		@Test
//		public void testGetVghByFirstName() throws JSONException {
//			ResponseEntity<String> response = template.getForEntity(all_vgh, String.class);
//		     String responseBody = response.getBody();
//		     int expectedNameLength = 50; 
//		     int actualNameLength = responseBody.split("\"vendorName\"")[1].split(":")[1].split("\"")[1].length();
//		     assertTrue( actualNameLength <= expectedNameLength);
//		}
//		private static String all_pay ="/api/v1/payments";
//		@Test
//		   public void testPriceDataType1() throws JSONException {
//		       ResponseEntity<String> response = template.getForEntity(all_pay, String.class);
//		       String responseBody = response.getBody();
//	 
//		       if (responseBody.contains("\"amount\"")) {
//		           String actualPriceString = responseBody.split("\"amount\"")[1].split(":")[1].trim();
//		           String actualPriceValue = actualPriceString.replaceAll("[^\\d.]", ""); 
//		           try {
//		               double actualPrice = Double.parseDouble(actualPriceValue);
//		               assertTrue(true, "Price is of type double");
//		           } catch (NumberFormatException e) {
//		               fail("Price is not of type double");
//		           }
//		       } else {
//		           fail("Price field not found in response body");
//		       }
//		   }
//		@Test
//		public void retrievepaymentsById() throws JSONException
//		{
//		String endpoint="http://localhost:1234/api/v1/payments/shou";
//		String payments="""
//						{
//							"payment_id": 1
//						}
//					""";
//		int payment_id=-1;
//		try {
//			payment_id = Validation.extractId(endpoint);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertFalse(payment_id >= 0, "Expected payment_id to be a positive integer");	
////		ResponseEntity<String> response = template.getForEntity(endpoint, String.class);
////		assertEquals("application/json",response.getHeaders().get("Content-Type").get(0));
////		assertTrue(response.getStatusCode().is2xxSuccessful());
////		JSONAssert.assertEquals(Users,response.getBody(), false);
////		assertEquals("keep-alive",response.getHeaders().get("Connection").get(0));
//	  }
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
// 
//
//	
//
//
// 
//
