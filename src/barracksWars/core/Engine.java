package barracksWars.core;

import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) {
		Executable executable = null;

		try {
			Class<?> command =
					Class.forName(getCorrectClassName(commandName));
			Constructor<?> ctor = command.getDeclaredConstructor(String[].class, UnitFactory.class, Repository.class);
			executable = (Executable) ctor.newInstance(data, this.unitFactory, this.repository);

		} catch (ClassNotFoundException | NoSuchMethodException
				| InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return executable != null ? executable.execute() : null;
	}


	private String getCorrectClassName(String commandName) {

		String substring = commandName.substring(1);

		String className = Character.toUpperCase(commandName.charAt(0)) +  substring;

		return "barracksWars.core.commands." + className + "Command";
	}


}
