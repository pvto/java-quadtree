# java-quadtree

This implements a quad tree with some tree balancing options.

- a tree autoexpands both inwards and outwards;
- a configurable bucket size
- which you can manually or automatically adjust
- helps fine-tune performance where data distribution plays a role.

##Usage

Create a tree with static leaf size.  Tree branches on overflow, as would be expected.

```
QuadTree<Integer> q = new QuadTree<>();
q.LEAF_MAX_OBJECTS = 24;
q.place(1.0, 1.0, 42);
```

Do something on all objects within specific bounds.

```
for(QuadTree<Integer>.CoordHolder h : q.findAll(0.0, 0.0, 2.0, 2.0))
{
    System.out.println("found an item: " + h.o);
}
```

Create a tree with a dynamic leaf size that reflects the square root of the size of the growing tree.

```
QuadTree<Integer> q = new QuadTree<>();
q.DYNAMIC_MAX_OBJECTS = true;
q.MAX_OBJ_TARGET_EXPONENT = 0.5;

for(int i = 0; i < 1000000; i++)
{
    q.place(Math.round(Math.random()*1000), Math.round(Math.random()*1000), i);
}
```
