package org.ensa.mdoel;

import java.util.ArrayList;
import java.util.List;

public class Mission extends MissionComponent {

    private final List<MissionComponent> children = new ArrayList<>();

    public void add(MissionComponent component){
        children.add(component);
    }

    public void remove(MissionComponent component) {
        children.remove(component);
    }

    @Override
    public double cout() {
        return children.stream().mapToDouble(MissionComponent::cout).sum();
    }

    @Override
    public String view() {
        StringBuilder details = new StringBuilder("Mission details:\n");
        for (MissionComponent component : children) {
            details.append(" - ").append(component.view()).append("\n");
        }
        return details.toString();
    }


}
