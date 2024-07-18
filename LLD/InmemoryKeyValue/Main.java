package LLD.InmemoryKeyValue;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
IN memory Data store Application -  (75 min Coding + 15min Review)
Problem Statement
Design an In-Memory Key-Value Store like Redis.
Requirements
The key-value store will be in-memory and does not require access to the file system.
The key will always be a string.
The value would be an object/map. The object would have attributes and corresponding values.
e.g. => "clear_emp1": { "Desg.": "Developer", "Name": “Dheeraj”, "Working_mode": 1,”Team”:”Engg”}
"clear_emp2": { "Desg.": "HR", "Name": “HRLear”, "Working_mode":  2, location : “bangalore”, “Team”: “Hr”}
Each attribute key would be a string and the attribute values could be string, integer, double or boolean.

//kay and values
map<String , map<String,Object>  hashMap

Map<String,objectType> uniquetypeOfelements

Set<String, Object>

search(“Desg”, “Developer”)

The key-value store should be thread-safe.(Without using concurrent hashmaps/ system utils)
The Key-Value store should expose the following functions:

GET(String key) => Should return the value (object with attributes and their values). Return null if the key is not present.
get(clear_emp1) :
 { "Desg.": "Developer", "Name": “Dheeraj”, "Working_mode": 1}


Search(String attributeKey, Object attributeValue) => Returns a list of keys that have the given attribute key, value pair.
("Desg.": "Developer")
Search : (team : eng) :
Key1, Key2



PUT(String key, List<Pair<String, Object>> listOfAttributePairs) => Adds the key and the attributes to the key-value store. If the key already exists then the value is replaced.

	Put : (emp1 ) : {Name: dheeraj, desg : developer, team: eng}
	Put : (emp2 ) : {Name: clear, desg : CA, team: finance}
	Put : (emp3 ) : {Name: tax, desg : manager, team: eng}

DELETE(String key) => Deletes the key, value pair from the store.

KEYS() => Return a list of all the keys.

The data type of an attribute should get fixed after its first occurrence.
Put : (emp1 ) : {Name: tax, desg : 2, team: eng} -> success
Put : (emp2 ) : {Name: clear, desg : CA, team: finance} -> it should fail
	Put : (emp3 ) : {Qwerty: abhilash, hobby: cricket} -> success
Put : (emp4 ) : {Name: clear, desg : 123, team: finance} -> success
Put : (emp5 ) : {Actor: SRK, desg : 222, movie: DDLJ} -> success
Attribute keys can be anything, it is not fixed.
 And data type validation  should work across keys in the entire map.

Map<String,Map<String, Object>> inMemoryDataStore

Please NOTE - If the key is removed from redis, then again its data type can be changed

i.e: Once we encounter an attribute desg with an integer value then any entry with an desg attribute having a non-integer value should cause invalid scenario.


Input Format
Single/Multiple lines with each line containing a command.
Possible commands:
GET  : GET(“clear_emp1”) :  "Desg.": "Developer", "Name": “Dheeraj”, "Working_mode":  “Remote”

PUT : PUT : (clear_emp1 : { "Desg.": "Developer", "Name": “Dheeraj”, "Working_mode":  “Remote”}).
DELETE : Delete : clear_emp1
SEARCH : SEARCH(“Desg”, “Developer”)
KEYS : Keys

Expectation from this round
1. Code should be extensible.
2. Clean professional level code.
3. Functional Completeness including good modeling.
4. Demonstrable code is the first expectation. To do this, you can choose any interface you
are comfortable with - CLI, WebApp, MobileApp, APIs or even simply run the code
via Tests or a main method.
5. Please prioritize code compilation, execution, and completion.

 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        InMemoryKeyValueStore keyValueStore=new InMemoryKeyValueStore();
        List<Map.Entry<String,Object>> emp1Attributes=new ArrayList<>();
        emp1Attributes.add(new AbstractMap.SimpleEntry<>("Desg.","Developer"));
        emp1Attributes.add(new AbstractMap.SimpleEntry<>("Desg.","Developer"));
        emp1Attributes.add(new AbstractMap.SimpleEntry<>("Desg.","Developer"));
        emp1Attributes.add(new AbstractMap.SimpleEntry<>("Desg.","Developer"));

        keyValueStore.put("clear_emp1",emp1Attributes);
    }
}