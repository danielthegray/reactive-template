package reactive.template;

import java.util.Random;

import logist.agent.Agent;
import logist.behavior.ReactiveBehavior;
import logist.plan.Action;
import logist.plan.Action.Move;
import logist.plan.Action.Pickup;
import logist.simulation.Vehicle;
import logist.task.Task;
import logist.task.TaskDistribution;
import logist.topology.Topology;
import logist.topology.Topology.City;

public class ReactiveTemplate implements ReactiveBehavior {

	private Random random;
	private double pPickup;

	@Override
	public void setup(Topology topology, TaskDistribution td, Agent agent) {

		// Reads the discount factor from the agents.xml file.
		// If the property is not present it defaults to 0.95
		Double discount = agent.readProperty("discount-factor", Double.class,
				0.5);

//		java.util.List<City> cities = topology.cities();
//		int numberOfCities = cities.size();
//		for (int i=0;i<numberOfCities;i++) {
//			City cityFrom = cities.get(i);
//			double cityProb=0.0;
//			for (int j=0;j<numberOfCities;j++) {
//				City cityTo = cities.get(j);
//				System.out.println("Probability for task from "+cityFrom.name+" to"+
//				cityTo.name+" = "+ td.probability(cityFrom, cityTo));
//				cityProb += td.probability(cityFrom, cityTo);
//			}
//			System.out.println("----------------------------");
//			System.out.println("Total Prob for "+cityFrom.name+" = "+cityProb);
//			System.out.println("Prob of NO TASK: calc="+(1-cityProb)
//					+" obtained="+td.probability(cityFrom, null));
//			System.out.println();
//		}
		
		this.random = new Random();
		this.pPickup = discount;
	}

	@Override
	public Action act(Vehicle vehicle, Task availableTask) {
		Action action;

		if (availableTask == null || random.nextDouble() > pPickup) {
			City currentCity = vehicle.getCurrentCity();
			action = new Move(currentCity.randomNeighbor(random));
		} else {
			action = new Pickup(availableTask);
		}
		return action;
	}
}
