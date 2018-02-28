package pl.sdacademy.italianrestaurant.supply;

import java.util.*;

public class OrderElement {
    private final String elementType;
    private final Map<String, Set<String>> specifics;

    public OrderElement(String elementType) {
        this.elementType = elementType;
        this.specifics = new LinkedHashMap<>();
    }

    public void addSpecifics(String type, String specific){
        Set<String> collectionOfSpecificsForType = new LinkedHashSet<>();
        collectionOfSpecificsForType.add(specific);
        if (this.specifics.containsKey(type)){
            for (Map.Entry<String,Set<String>> mapEntry: this.specifics.entrySet()){
                if (mapEntry.getKey() == type) {
                    collectionOfSpecificsForType.addAll(mapEntry.getValue());


                }
            }
        }
        this.specifics.put(type,collectionOfSpecificsForType);


        //specifics.merge(type, collectionOfSpecificsForType, (oldSpecifics, newSpecifics) -> {oldSpecifics.addAll(newSpecifics); return oldSpecifics;});
    }

    public String getElementType() {
        return elementType;
    }

    public Map<String, Set<String>> getSpecifics() {
        return specifics;
    }
}
