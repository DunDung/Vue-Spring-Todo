<template>
  <section>
    <ul>
      <li v-for="(todoItem, index) in propsdata" :key="index" class="shadow">
        <i class="checkBtn fas fa-check" aria-hidden="true"></i>
          {{ todoItem }}
          <span class="removeBtn" type="button" @click="removeTodo(index)">
            <i class="far fa-trash-alt" aria-hidden="true"></i>
          </span>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  props: ['propsdata'],
  methods: {
    removeTodo (index) {
      this.$emit('removeTodo', index)
    }
  }
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0px;
  text-align: left;
}

li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}

.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 10px;
}

.removeBtn {
  margin-left: auto;
  color: #de4343;
}

</style>
