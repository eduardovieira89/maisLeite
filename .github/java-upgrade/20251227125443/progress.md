# Upgrade Progress

  ### ✅ Generate Upgrade Plan
  - [[View Log]](logs\1.generatePlan.log)

  ### ✅ Confirm Upgrade Plan
  - [[View Log]](logs\2.confirmPlan.log)

  ### ✅ Setup Development Environment
  - [[View Log]](logs\3.setupEnvironment.log)

  ### ✅ PreCheck
  - [[View Log]](logs\4.precheck.log)
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ✅ Precheck - Build project
    - [[View Log]](logs\4.1.precheck-buildProject.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Command
    `mvnw clean test-compile -q -B -fn`
    </details>
  
    ### ✅ Precheck - Validate CVEs
    - [[View Log]](logs\4.2.precheck-validateCves.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### CVE issues
    </details>
  
    ### ✅ Precheck - Run tests
    - [[View Log]](logs\4.3.precheck-runTests.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Test result
    | Total | Passed | Failed | Skipped | Errors |
    |-------|--------|--------|---------|--------|
    | 0 | 0 | 0 | 0 | 0 |
    </details>
  </details>

  ### ✅ Upgrade project to use `Spring Boot 3.4.x`
  
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ✅ Upgrade using Agent
    - [[View Log]](logs\5.1.upgradeProjectUsingAgent.log)
    
    - 1 file changed, 6 insertions(+), 6 deletions(-)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Code changes
    - Bump parent `spring-boot-starter-parent` to `3.4.0`
    - Validate build to detect required code/dependency changes for Spring Boot 3.4.x
    </details>
  
    ### ✅ Build Project
    - [[View Log]](logs\5.2.buildProject.log)
    
    - Build result: 100% Java files compiled
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Command
    `mvnw clean test-compile -q -B -fn`
    </details>
  </details>

  ### ✅ Upgrade project to use `Spring Boot 3.5.x`
  
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ✅ Upgrade using Agent
    - [[View Log]](logs\6.1.upgradeProjectUsingAgent.log)
    
    - 16 files changed, 1 insertion(+), 13 deletions(-)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Code changes
    - Bump parent `spring-boot-starter-parent` to `3.5.0`
    - Validate build to detect required code/dependency changes for Spring Boot 3.5.x
    </details>
  
    ### ✅ Build Project
    - [[View Log]](logs\6.2.buildProject.log)
    
    - Build result: 100% Java files compiled
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Command
    `mvnw clean test-compile -q -B -fn`
    </details>
  </details>

  ### ✅ Validate & Fix
  
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ✅ Validate CVEs
    - [[View Log]](logs\7.1.validateCves.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Checked Dependencies
      - org.springframework.boot:spring-boot-starter-actuator:3.5.0:jar
      - org.springframework.boot:spring-boot-starter-data-jpa:3.5.0:jar
      - org.springframework.data:spring-data-rest-webmvc:4.5.0:jar
      - org.springframework.boot:spring-boot-starter-security:3.5.0:jar
      - org.springframework.boot:spring-boot-starter-web:3.5.0:jar
      - com.mysql:mysql-connector-j:9.2.0:jar
      - org.projectlombok:lombok:1.18.38:jar
      - org.springframework.boot:spring-boot-starter-test:3.5.0:jar
      - org.springframework.security:spring-security-test:6.5.0:jar
      - org.springframework.boot:spring-boot-starter-validation:3.5.0:jar
      - com.h2database:h2:2.3.232:jar
      - org.junit.platform:junit-platform-runner:1.12.2:jar
    </details>
  
    ### ✅ Validate Code Behavior Changes
    - [[View Log]](logs\7.2.validateBehaviorChanges.log)
  
    ### ✅ Run Tests
    - [[View Log]](logs\7.3.runTests.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Test result
    | Total | Passed | Failed | Skipped | Errors |
    |-------|--------|--------|---------|--------|
    | 0 | 0 | 0 | 0 | 0 |
    </details>
  </details>

  ### ✅ Summarize Upgrade
  - [[View Log]](logs\8.summarizeUpgrade.log)