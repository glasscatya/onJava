package com.glasscat.corejava.pair3;

import java.time.*;

public class Employee
{  
   private String name;
   private double salary;
   private LocalDate hireDay;

   public Employee(String name, double salary, int year, int month, int day)
   {
      this.name = name;
      this.salary = salary;
      hireDay = LocalDate.of(year, month, day);
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {  
      return salary;
   }

   public LocalDate getHireDay()
   {  
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {  
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   @Override
   public String toString() {
      return  this.getClass().getSimpleName() + "{" +
              "name='" + name + '\'' +
              ", salary=" + salary +
              ", hireDay=" + hireDay +
              '}';
   }
}

