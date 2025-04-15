# Elevator mini project
### Coded by Mariana Vadas-Arendt

    In this project, I simulated an elevator using Java 21. The main code (Building class) will take in an array of
    floors and will visit each floor. The floors are generated from an array of floor numbers (integers).
    Each floor can have either a single button or up/down buttons. When the floor has a single button, it will chose 
    either the next floor on the list of floors given, or it will find the closest floor that needs to be visited. This
    depends on the strategy given to the elevator. The elevator has two strategy options: optimized or regular.
    The optimized strategy will provide the quickest order of floors visited. The regular strategy follows the 
    order that was entered more so. When the floor has the up/down buttons, it will go up or down according to
    which button was entered with the floor number at initialization. If the button is down, but there are no lower
    floors left to visit, then the elevator will go up. If the button is up, but there are no higher floors left to 
    visit, then the elevator will go down. 