<br />
<div align="center">
  <a href="https://github.com/Balachonov/delivery-food">
    <img src="src/images/logo.png" alt="El'Grillgo" width="80" height="80">
  </a>

<h3 align="center">Delivery food</h3>

  <p align="center">
   Balaсhonov Alexei’s study project!
    <br />
    <a <strong>Sample application for ordering food from the restaurant "El'Grillgo"</strong></a>

  </p>
</div>

## About The Project

This food delivery app is a convenient and fast way to order food from your favorite El'Grillgo restaurant directly to your home or office. With our app you can easily and quickly select dishes from the restaurant menu, add them to the cart and place an order.
To clarify the details of the order, our manager will contact you on the specified phone number. We guarantee high quality food and service so you can enjoy delicious food anytime and anywhere.

You can also contact us by email (el.grilgo@gmail.com) or write to our best developer (balachonov@gmail.com)


The project was gradually developed during four montns of training:
* First month - Web Servlet application, Prepared statements in data base
* Second month - Hibernate, Hibernate Query Language, Criteria API
* Third month - gradual transition to Spring
* Fourth month - Spring Boot, Spring Data JPA, JUnit 5, Spring Security (сryptography), Spring Email, Spring Cloud
* Current time - create user authentication and authorization

## Roadmap

- [x] Spring Boot
- [x] Spring Data JPA
- [x] CRUD servise for entities
- [x] Test for service
- [x] Spring Security for сryptography password
- [x] Email service
- [x] Cloud application configuration
- [x] Spring Cloud Netflix Eureka
- [x] Remote API to get a recipe of day
- [x] Remote API to backup data remote users
- [ ] User authentication and authorization
- [ ] Business development logic application
- [ ] Transition and development of the application’s microservice architecture
- [ ] Multi-language Support
    - [x] English
    - [ ] Russian
    - [ ] Chinese

## Technologies

The project was developed using:
* PostgreSQL
* Mapstruct
* Lombok
* Libphonenumber
* Spring
    * Data JPA
    * Validation
    * Cloud config
    * Mail
    * Test
    * OpenFeign
    * Netflix Eureka
    * Security

## Remote API

1. Remote application registration - <a href="https://github.com/Balachonov/eureka-app-cloud">Eureka server</a>
2. Cloud settings of the main application - <a href="https://github.com/Balachonov/cloud-config-delivery-food">Settings service</a>
3. Generating and sending day recipe - <a href="https://github.com/Balachonov/recipe-day">Recipe service</a>
4. Accessing and saving remote users in a separate database - <a href="https://github.com/Balachonov/archive-server">Archive service</a>

## Demonstration of some project possibilities

A confirmation email will be sent to your email address when you sign in or order.  
![Example mail](/src/images/mail.png)

Pagination and sorting by your parameter implemented.

```java
@GetMapping(value = "/persons/{pageNumber}/{pageSize}/{sort}")
    public List<PersonResponse> getPersons(@PathVariable Integer pageNumber,
                                           @PathVariable Integer pageSize,
                                           @PathVariable String sort) {
        Page<PersonResponse> data = personService.getPersons(pageNumber, pageSize, sort) ;
        return data.getContent();
    }
```

AOP logging of controllers implemented.
```java
@Pointcut("execution(* balachonov.controllers..*(..)) " +
            "&& !@annotation(balachonov.aspects.anotations.SkipLog)")
    private void getControllersPointcut() {
    }

@AfterReturning(pointcut = "getControllersPointcut()", returning = "response")
    private void logResponse(JoinPoint joinPoint, Object response) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(RESPONSE_LOGGER_PATTERN,
                request.getMethod(),
                request.getRequestURI(),
                joinPoint.getSignature().toShortString(),
                ofNullable(response).orElse(EMPTY));
    }
```

Validation of phone numbers by means of annotation.
```java
public class PhoneNumberConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    @SneakyThrows
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber blrPhoneNumber = phoneUtil.parse(phone, CODE_BELARUS);
        return phoneUtil.isValidNumberForRegion(blrPhoneNumber, CODE_BELARUS)
                && phoneUtil.isPossibleNumberForType(blrPhoneNumber, FIXED_LINE_OR_MOBILE);
    }
}
```
Exception handler with ResponseStatusException
```java
@ExceptionHandler(EntityNotFoundException.class)
    public ResponseStatusException handleUserNotFoundException(EntityNotFoundException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
        return new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
    }
```

<a href="https://github.com/Balachonov/delivery-food">More code examples</a>

## Contact

Alexey Balachonov - balachonov@gmail.com

Project Link: [https://github.com/Balachonov?tab=repositories](https://github.com/Balachonov?tab=repositories)

## My trainers

Aleksandr Moskalchuk - moskalchukaleksandr@gmail.com  
Dmitriy Steba - stebadmitriy@gmail.com 

