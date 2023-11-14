package com.eidiko.niranjana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.eidiko.niranjana.entity.Students;
@Repository
public interface IStudentsRepo extends JpaRepository<Students, Integer> {
	
	
	//@Query("FROM  com.nt.entity.Employee ")             //writing "SELECT" is optional, if we fetching all the data at a time..
	 //@Query("FROM  Employee ")
	//@Query("FROM  Employee e ")
	 @Query("SELECT  e FROM  Students e ")               //--------->this is JPQL/HQL query
	 //@Query(value ="select *from Students", nativeQuery=true)
	 public  List<Students> fetchAllStudents();
	 
	//fetch all students data by using ID using "named param"					//--------->this is JPQL/HQL query
	@Query("SELECT sno,sname,saddrs,ssal FROM  Students  WHERE sno=:no")  //Here named param(:no) and method param(no) both are must same...otherwise IllegalStateException
	public Object findStdPartialDetailsById(Integer no);
	
	//fetch all students data by using NAME using "named param"					//--------->this is JPQL/HQL query
	@Query("SELECT sno,sname,saddrs,ssal FROM  Students  WHERE sname=:name")  //Here named param(:name) and method param(name) both are must same...otherwise IllegalStateException
	public Object findStdPartialDetailsByName(String name);
	
	
	//fetch all students data by using ID using "@Param annotation"					//--------->this is JPQL/HQL query
	@Query("SELECT sno,sname,saddrs,ssal FROM  Students  WHERE sname=?1")
	public Object fetchStudentsAllDetailsByName(@Param("name")String name);
		
		
	//fetch all students data by using ID using "@Param annotation"					//--------->this is JPQL/HQL query
	@Query("SELECT sno,sname,saddrs,ssal FROM  Students  WHERE sno=?1")
	public Object fetchStudentsAllDetailsById(@Param("no")Integer no);
		
	 //fetch all students data by using ADDRS using "@Param annotation"
	@Query("from Students where saddrs=:city")
	public List<Students> fetchAllStudentsDetailsByAddrs(@Param("city")String addrs);
	
	//fetch all students data those are between two salary range
	@Query("from Students where ssal>=:start and ssal<=:end")
	public List<Students> fetchStudentsDetailsBySalaryrange(float start, float end);
	
	//fetch all students data those are between two Sno Range
	@Query("from Students where sno>=:start and sno<=:end")
	public List<Students> fetchStudentsDetailsBySnoRange(Integer start, Integer end);
	
	//fetching specific multiple columns value from Students value
	@Query("select sno,sname,ssal from Students where saddrs IN(:city1,:city2)")
	public List<Object> fetchStudentsDetailsByCities(String city1, String city2);
	
	
	//fetching specific multiple columns value from Students value
	@Query("select sno,sname,ssal from Students where saddrs IN(:city1,:city2)")
	public List<Students> fetchStudentsDetailsByCities1(String city1, String city2);
	
	//fetching Students details By his InitialLetter
	//@Query("select sname from Students where sname like:S%")  //--------------------------->ERROR, not solved
	//public List<Object> fetStudentsDetailsByUsingInitialLetter(String S);
	 
	//get Students Count
	@Query("SELECT  COUNT(*) FROM Students")
    public    int      getStudCount();
	
	//get Maximum salary, Minimum salary, Aggregate salary of Students
	//public Object getStudsAggerateData();
	
}	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//	
	    //@Query("FROM  com.nt.entity.Employee ")
	   //@Query("FROM  Employee ")
	   //@Query("FROM  Employee e ")
	   // @Query("SELECT  e FROM  Employee e ")
	  // public  List<Students> fetchAllEmployees();
	    /*
	    @Query(" FROM  Employee WHERE  eadd=?1")
	    //@Query(" FROM  Employee WHERE  eadd=:city")
	    public  List<Employee>  fetchAllEmployeesByAddrs(@Param("city")String addrs);
	    
	    @Query("FROM Employee WHERE esalary>=:start and esalary<=:end")
	    public  List<Employee>  fetchAllEmployeeBySalaryRange(float start, float end);
	    
	    //------------------------- Retrieving specific multiple col values (scalar /Projections in BulkSelect ) --------------------------
	    @Query("SELECT eno,ename,esalary FROM  Employee WHERE eadd in(:city1,:city2,:city3)")
	    public List<Object[]>  fetchEmpDetailsByCities(String city1,String city2,String city3);
	    
	    @Query("SELECT eno,ename FROM  Employee WHERE ename like :initialLetters%")
	    public List<Object[]> fetchEmpDetailsByNameInitialLetters(String initialLetters);
	    
	    //------------------------- Retrieving specific single col values (scalar /Projections in BulkSelect ) --------------------------
	    @Query("SELECT ename FROM  Employee WHERE eno>=:start and eno<=:end")
	    public  List<String>  findEmpNamesByEnoRange(int start ,int end);
	    
	    @Query("SELECT esalary FROM  Employee WHERE ename IN(:name1,:name2,:name3)")
	    public  List<Float>  findEmpSalaryByEnames(String name1,String name2,String name3);
	    
	  //------------------------- Retrieving all col values of single row (Entity Operation in SingleRow Select query ) --------------------------
	    @Query(" FROM  Employee WHERE eno=:no")
	    public Employee  findEmpAllDetailsByEno(int no);
	    
		  //------------------------- Retrieving specific multiple   col values of singlerow (scalar/Projection Operation in SingleRow Select query ) --------------------------
	    @Query("SELECT eno,eadd FROM  Employee WHERE eno=:no")
	    public     Object  findEmpPartialDetailsByEno(int no);
	    
	    //------------------------- Retrieving specific single   col value of singlerow (sclar/Projection Operation in SingleRow Select query ) --------------------------
	    @Query("SELECT esalary FROM  Employee WHERE eno=:no")
	    public     float  findEmpSalaryByEno(int no);
	    
	    //-------------------- Supports  aggregate functions (HQL/JPQL) -------------------
	    @Query("SELECT  COUNT(*) FROM Employee")
	    public    int      getEmpsCount();
	        
	    @Query("SELECT  COUNT(*),MAX(esalary),MIN(esalary),avg(esalary) FROM Employee")
	   public    Object    getEmpsAggerateData(); 
	    
	    //--------------   HQL/JPQL  Non-select operations (except insert operation) -----------------------
	    @Query("UPDATE Employee SET esalary=esalary+ :amount WHERE  esalary<=:startSalary")
	    @Modifying
	    @Transactional
	           public int  updateEmpSalaryByAmount(float startSalary, float amount);
	    
	    @Query("DELETE FROM Employee WHERE  eadd IS NULL")
	    @Modifying
	    @Transactional
	    public  int   deleteEmpsHavingNoAddrs();
	    
	    //-------------------------- Native SQL @Query methods  -------------------------------
	    @Query(value="SELECT SYSDATE  FROM DUAL",nativeQuery=true)
	    public  String  getSysDate();
	    
	    @Query(value="INSERT INTO EMPLOYEE VALUES(?,?,?,?)",nativeQuery=true)
	    @Modifying
	    @Transactional
	    public  int  insertEmployee(int no,float salary,  String addrs ,String name);
	   */

