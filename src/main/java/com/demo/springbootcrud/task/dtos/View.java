package com.demo.springbootcrud.task.dtos;

/**
 * @author webwerks
 *
 *This class represents various views for {@link @JsonView}
 */
public class View {
	
	public interface DummyView {}

	public interface TitleAndId extends DummyView {}
	
	public interface Title extends DummyView {}
	
}
