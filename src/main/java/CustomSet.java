//import java.util.*;
//
//public class SnapshotSet {
//
//    private Iterator<Integer> currentIterator;
//
//    static class SnapshotIterator implements Iterator<Integer> {
//        private final List<Integer> snapshotKeys;
//        private final int snapshotId;
//        private final Map<Integer, List<Operation>> operationHistory;
//        private final Iterator<Integer> keyIterator;
//        private Integer nextValidElement;
//
//        public SnapshotIterator(int snapshotId, Map<Integer, List<Operation>> operationHistory, Set<Integer> currentKeys) {
//            this.snapshotId = snapshotId;
//            this.operationHistory = operationHistory;
//            this.snapshotKeys = new ArrayList<>(currentKeys); // Freeze current keys
//            this.keyIterator = snapshotKeys.iterator();
//            this.nextValidElement = findNextValidElement();
//        }
//
//        private boolean isElementActive(int element, int snapshotId) {
//            if (!operationHistory.containsKey(element)) {
//                return false;
//            }
//            List<Operation> operations = operationHistory.get(element);
//            int low = 0, high = operations.size() - 1;
//            Operation mostRecentOperation = null;
//
//            // Binary search for the most recent valid operation
//            while (low <= high) {
//                int mid = (low + high) / 2;
//                if (operations.get(mid).snapshotId <= snapshotId) {
//                    mostRecentOperation = operations.get(mid);
//                    low = mid + 1; // Search for a more recent valid operation
//                } else {
//                    high = mid - 1;
//                }
//            }
//
//            return mostRecentOperation != null && mostRecentOperation.operationType == OperationType.ADD;
//        }
//
//        private Integer findNextValidElement() {
//            while (keyIterator.hasNext()) {
//                int candidate = keyIterator.next();
//                if (isElementActive(candidate, snapshotId)) {
//                    return candidate;
//                }
//            }
//            return null;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return nextValidElement != null;
//        }
//
//        @Override
//        public Integer next() {
//            if (nextValidElement == null) {
//                throw new NoSuchElementException();
//            }
//            Integer current = nextValidElement;
//            nextValidElement = findNextValidElement();
//            return current;
//        }
//    }
//
//    static class Operation {
//        int snapshotId;
//        OperationType operationType;
//
//        public Operation(int snapshotId, OperationType operationType) {
//            this.snapshotId = snapshotId;
//            this.operationType = operationType;
//        }
//    }
//
//    enum OperationType {
//        REMOVE,
//        ADD
//    }
//
//    private final Set<Integer> activeElements;
//    private final Map<Integer, List<Operation>> operationHistory;
//    private int currentSnapshotId;
//
//    public SnapshotSet() {
//        this.activeElements = new HashSet<>();
//        this.operationHistory = new HashMap<>();
//        this.currentSnapshotId = 0;
//    }
//
//    public boolean add(int element) {
//        activeElements.add(element);
//        operationHistory.putIfAbsent(element, new ArrayList<>());
//        List<Operation> operations = operationHistory.get(element);
//        if (!operations.isEmpty() && operations.get(operations.size() - 1).snapshotId == this.currentSnapshotId) {
//            operations.set(operations.size() - 1, new Operation(currentSnapshotId, OperationType.ADD));
//        } else {
//            operations.add(new Operation(currentSnapshotId, OperationType.ADD));
//        }
//        return true;
//    }
//
//    public boolean remove(int element) {
//        if (!activeElements.contains(element)) {
//            return false;
//        }
//        activeElements.remove(element);
//        operationHistory.putIfAbsent(element, new ArrayList<>());
//        List<Operation> operations = operationHistory.get(element);
//        if (!operations.isEmpty() && operations.get(operations.size() - 1).snapshotId == this.currentSnapshotId) {
//            operations.set(operations.size() - 1, new Operation(currentSnapshotId, OperationType.REMOVE));
//        } else {
//            operations.add(new Operation(currentSnapshotId, OperationType.REMOVE));
//        }
//        return true;
//    }
//
//    public boolean contains(int element) {
//        return activeElements.contains(element);
//    }
//
//    public Iterator<Integer> iterator() {
//        currentIterator = new SnapshotIterator(currentSnapshotId, operationHistory, activeElements);
//        currentSnapshotId++;
//        return currentIterator;
//    }
//
//    public void printAll() {
//        if (currentIterator != null) {
//            while (currentIterator.hasNext()) {
//                System.out.println(currentIterator.next());
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SnapshotSet snapshotSet = new SnapshotSet();
//        snapshotSet.add(3);
//        snapshotSet.add(1);
//        snapshotSet.add(2);
//
//        Iterator<Integer> firstIterator = snapshotSet.iterator();
//        snapshotSet.add(4);  // Should not affect firstIterator
//        snapshotSet.remove(3);  // Should not affect firstIterator
//        while (firstIterator.hasNext()) {
//            System.out.println(firstIterator.next());
//        }
//
//        Iterator<Integer> secondIterator = snapshotSet.iterator();
//        while (secondIterator.hasNext()) {
//            System.out.println(secondIterator.next());
//        }
//    }
//}
