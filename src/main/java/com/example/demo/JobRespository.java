package com.example.demo;

import org.springframework.data.repository.CrudRepository;
/*This interface will acts as a "pipeline" to the data base.
 *
 * The Job Repository has in-built methods that you can use to save,
 *  locate, and delete data. The Job Repository can return single or
 * multiple instances of the jobs that are in the                                                          
 *  ex: findall() findbyId()*/
public interface JobRespository  extends CrudRepository<Job, Long> {
}
