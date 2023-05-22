public interface ItemService {
    @Transactional
    public Item save(Item item);

    @Transactional(readOnly = true)
    public List<Item> findAll();

    @Transactional(readOnly=true)
    public Item findById(long id);
    @Transactional
    public void update(Long id, Item item);
}
