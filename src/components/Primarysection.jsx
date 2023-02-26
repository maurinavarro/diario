import React from "react";

const Primarysection = () => {
  return (
      <div className="flex flex-col mx-5 md:flex-row my-14 bg-white md:mx-4 lg:mx-6 xl:mx-6 2xl:mx-20">
        <div className="xl:w-[696px]">
          <img className="xl:h-[348px] objet-cover w-full" src="../public/img1.jpg" alt="" />
          </div>
        <div className="xl:w-[696px] md:pl-5 xl:pt-20">
          <h2 className="py-4 font-poppins font-semibold text-lg lg:text-xl xl:text-2xl">Este es un título de ejemplo para la primer noticia</h2>
        <p className="font-light font-crimson text-base xl:text-lg">Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur error voluptates fuga vitae libero dolore quae, rem sunt aspernatur? Deleniti temporibus architecto dicta eveniet</p>
        </div>
      </div>
  );
};

export default Primarysection;
