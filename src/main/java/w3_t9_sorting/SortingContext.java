package w3_t9_sorting;

public class SortingContext {
    private SortingInterface sortingAlgorithm;

    public SortingContext(SortingInterface algorithm) {
        this.sortingAlgorithm = algorithm;
    }

    public void setStrategy(SortingInterface algorithm) {
        this.sortingAlgorithm = algorithm;
    }

    public Integer[] sort(Integer[] arrayForSorting) {
        return sortingAlgorithm.sort(arrayForSorting);
    }
}
